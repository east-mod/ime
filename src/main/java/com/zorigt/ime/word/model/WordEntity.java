package com.zorigt.ime.word.model;

import com.zorigt.ime.approximate.matching.MountObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordEntity implements MountObject {
    private int id;
    private String str;
    private int length;
    private long frequency;

    public WordEntity(String str, long frequency) {
        this.str = str;
        this.length = str.length();
        this.frequency = frequency;
    }

    public WordEntity(String str) {
        this.str = str;
        this.length = str.length();
        this.frequency = 0L;
    }

    public void incrementFrequency() {
        frequency++;
    }

    public void addFrequency(long number) {
        this.frequency += number;
    }

    public static WordEntity create(final String str) {
        WordEntity wordEntity = new WordEntity();
        wordEntity.setStr(str);
        wordEntity.setLength(str.length());
        wordEntity.setFrequency(0L);
        return wordEntity;
    }

    @Override
    public String getString() {
        return this.str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WordEntity that = (WordEntity) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), str);
    }
}
