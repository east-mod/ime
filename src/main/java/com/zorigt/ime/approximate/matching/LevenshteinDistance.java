package com.zorigt.ime.approximate.matching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevenshteinDistance {
    private static final transient Logger logger = LoggerFactory.getLogger(LevenshteinDistance.class);

    public LevenshteinDistance() {
    }

    public int getDistance(CharSequence a, CharSequence b) {
        int n = a == null ? 0 : a.length();
        int m = b == null ? 0 : b.length();

        if (n != 0 && m != 0) {
            int[][] d = new int[n + 1][m + 1];
            d[0][0] = 0;
            for (int j = 1; j <= m; j++) {
                d[0][j] = j;
            }

            for (int i = 1; i <= n; i++) {
                d[i][0] = i;
                for (int j = 1; j <= m; j++) {
                    int cost = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                    d[i][j] = Math.min((Math.min(d[i - 1][j], d[i][j - 1]) + 1), d[i - 1][j - 1] + cost);
                }
            }

//        return (int) (d[n][m] / Math.max(n, m)) * 100;
            return d[n][m];
        } else {
            return m == n ? 0 : Math.max(n, m);
        }
    }
}
