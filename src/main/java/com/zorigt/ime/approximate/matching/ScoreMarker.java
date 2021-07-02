package com.zorigt.ime.approximate.matching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreMarker {
    private final Logger logger = LoggerFactory.getLogger(ScoreMarker.class);

    private final List<SuggestWord> suggestWordList;

    private final JaroWinklerDistance jaroWinklerDistance;

    private final String str;

    private long maxFrequency;

    private float frequencyThreshold = 0.15F;

    private float levenshteinThreshold = 0.50F;

    private float jaroWinklerThreshold = 1F;

    public ScoreMarker(String str) {
        this.suggestWordList = Collections.synchronizedList(new ArrayList<>(128));
        this.jaroWinklerDistance = new JaroWinklerDistance();
        this.str = str;
    }

    public void add(final SuggestWord suggestWord) {
        suggestWordList.add(suggestWord);
    }

    public void setMaxFrequency(long maxFrequency) {
        if (this.maxFrequency < maxFrequency) {
            this.maxFrequency = maxFrequency;
        }
    }

    public void markAndFilter() {
        float maxLength = 0;
        for (SuggestWord sw : suggestWordList) {
            if (maxLength < sw.getLength()) {
                maxLength = sw.getLength();
            }
        }

        float maxScore = frequencyThreshold +
                jaroWinklerThreshold * jaroWinklerDistance.getDistance(str, str) +
                computeLevenshteinScore(str.length(), 0, maxLength) * levenshteinThreshold;

        for (int i = suggestWordList.size() - 1; i >= 0; i--) {
            SuggestWord sw = suggestWordList.get(i);
            sw.setLevenshteinScore(computeLevenshteinScore(sw.getLength(), sw.getLevenshteinD(), maxLength));
            sw.setJaroWinklerScore(jaroWinklerDistance.getDistance(str, sw.getStr()));
            if (sw.getJaroWinklerScore() < 1) {
                suggestWordList.remove(i);
                continue;
            }
            sw.setFrequencyScore((float) sw.getFrequency() / (float) maxFrequency);
            sw.setScore(sw.getFrequencyScore() * frequencyThreshold +
                    sw.getJaroWinklerScore() * jaroWinklerThreshold +
                    sw.getLevenshteinScore() * levenshteinThreshold);

            sw.setScore(sw.getScore() / maxScore);
        }
    }

    private float computeLevenshteinScore(int length, int levenshteinDistance, float maxLength) {
        return 1.0F - (((float) length / 2f + (float) levenshteinDistance) / (1.5f * maxLength));
    }

    public List<SuggestWord> getSuggestWordList() {
        return suggestWordList;
    }

    public float getFrequencyThreshold() {
        return frequencyThreshold;
    }

    public void setFrequencyThreshold(float frequencyThreshold) {
        this.frequencyThreshold = frequencyThreshold;
    }

    public float getLevenshteinThreshold() {
        return levenshteinThreshold;
    }

    public void setLevenshteinThreshold(float levenshteinThreshold) {
        this.levenshteinThreshold = levenshteinThreshold;
    }

    public float getJaroWinklerThreshold() {
        return jaroWinklerThreshold;
    }

    public void setJaroWinklerThreshold(float jaroWinklerThreshold) {
        this.jaroWinklerThreshold = jaroWinklerThreshold;
    }
}
