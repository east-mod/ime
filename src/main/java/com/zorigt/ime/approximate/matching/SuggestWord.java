package com.zorigt.ime.approximate.matching;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuggestWord implements MountObject {
    private String str;
    private int length;
    private long frequency;
    private int levenshteinD;

    private float jaroWinklerScore;
    private float frequencyScore;
    private float levenshteinScore;
    private float score;

    public SuggestWord(String str, int length, long frequency, int levenshteinD) {
        this.str = str;
        this.length = length;
        this.frequency = frequency;
        this.levenshteinD = levenshteinD;
    }

    @Override
    public String getString() {
        return this.str;
    }

    @Override
    public String toString() {
        return this.str + ",frequency:" +
                this.frequency +
                ",frequencyScore:" + this.frequencyScore +
                ",levenshteinD:" + this.levenshteinD +
                ",levenshteinScore:" + this.levenshteinScore +
                ",jaroWinklerScore:" + this.jaroWinklerScore +
                ",score:" + this.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SuggestWord that = (SuggestWord) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    public static int contains(List<SuggestWord> suggestWordList, String str) {
        for (int i = 0; i < suggestWordList.size(); i++) {
            if (suggestWordList.get(i).getStr().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> convert(List<SuggestWord> suggestWordList) {
        if (CollectionUtils.isNotEmpty(suggestWordList)) {
            return suggestWordList.stream().map(SuggestWord::getStr).collect(Collectors.toList());
        }
        return new LinkedList<>();
    }
}