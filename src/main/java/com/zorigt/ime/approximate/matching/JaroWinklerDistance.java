package com.zorigt.ime.approximate.matching;

import java.util.Arrays;

public class JaroWinklerDistance {
    private float threshold = 0.7F;

    public JaroWinklerDistance() {
    }

    private int[] matches(String s1, String s2) {
        String max;
        String min;
        if (s1.length() > s2.length()) {
            max = s1;
            min = s2;
        } else {
            max = s2;
            min = s1;
        }

        int range = max.length();
        int[] matchIndexes = new int[min.length()];
        Arrays.fill(matchIndexes, -1);
        boolean[] matchFlags = new boolean[max.length()];
        int matches = 0;

        int transpositions;
        int prefix;
        for (int mi = 0; mi < min.length(); ++mi) {
            char c1 = min.charAt(mi);
            transpositions = Math.max(mi - range, 0);

            for (prefix = Math.min(mi + range + 1, max.length()); transpositions < prefix; ++transpositions) {
                if (!matchFlags[transpositions] && c1 == max.charAt(transpositions)) {
                    matchIndexes[mi] = transpositions;
                    matchFlags[transpositions] = true;
                    ++matches;
                    break;
                }
            }
        }

        char[] ms1 = new char[matches];
        char[] ms2 = new char[matches];
        transpositions = 0;

        for (prefix = 0; transpositions < min.length(); ++transpositions) {
            if (matchIndexes[transpositions] != -1) {
                ms1[prefix] = min.charAt(transpositions);
                ++prefix;
            }
        }

        transpositions = 0;

        for (prefix = 0; transpositions < max.length(); ++transpositions) {
            if (matchFlags[transpositions]) {
                ms2[prefix] = max.charAt(transpositions);
                ++prefix;
            }
        }

        transpositions = 0;

        for (prefix = 0; prefix < ms1.length; ++prefix) {
            if (ms1[prefix] != ms2[prefix]) {
                ++transpositions;
            }
        }

        prefix = 0;

        for (int mi = 0; mi < min.length() && s1.charAt(mi) == s2.charAt(mi); ++mi) {
            ++prefix;
        }

        return new int[]{matches, transpositions / 2, prefix, min.length()};
    }

    public float getDistance(String s1, String s2) {
        int[] mtp = this.matches(s1, s2);
        float m = (float) mtp[0];
        if (m == 0.0F) {
            return 0.0F;
        } else {
            //Jaro Distance
            float j = (m / (float) s1.length() + m / (float) s2.length() + (m - (float) mtp[1]) / m) / 3.0F;
            //Jaro Winkler Distance
//            return j < this.getThreshold() ? j : j + Math.min(0.1F, 1.0F / (float) mtp[3]) * (float) mtp[2] * (1.0F - j);
            if (j < this.getThreshold() || (float) mtp[2] <= 0) {
                return j;
            } else if ((float) mtp[2] >= Math.max(s1.length() - 1, 2)) {
                return 2.0F + j + (float) mtp[2] / (float) mtp[3] * (1.0F - j);
            } else {
                return 1.0F + j + (float) mtp[2] / (float) mtp[3] * (1.0F - j);
            }
        }
    }

    public float getThreshold() {
        return threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }
}
