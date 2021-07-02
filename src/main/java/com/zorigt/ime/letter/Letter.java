package com.zorigt.ime.letter;

public abstract class Letter {
    protected final String latinKey;

    public Letter(String latinKey) {
        this.latinKey = latinKey;
    }

    public String getLatinKey() {
        return latinKey;
    }
}
