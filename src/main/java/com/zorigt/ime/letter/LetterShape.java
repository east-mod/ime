package com.zorigt.ime.letter;

import com.zorigt.ime.letter.splice.SplicingAtBehindRule;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.Objects;

public class LetterShape {
    protected final String latinKey;
    protected final String shape;
    protected final byte location;

    protected SplicingAtFrontRule fuzzyFrontAtRule;
    protected SplicingAtBehindRule fuzzyBehindAtRule;

    protected SplicingAtFrontRule severeFrontAtRule;
    protected SplicingAtBehindRule severeBehindAtRule;

    public LetterShape(String latinKey, String shape, byte location) {
        this.latinKey = latinKey;
        this.shape = shape;
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LetterShape that = (LetterShape) o;
        return location == that.location &&
                latinKey.equals(that.latinKey) &&
                shape.equals(that.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latinKey, shape, location);
    }

    @Override
    public String toString() {
        return this.latinKey + "_" + this.location + "_" + this.shape;
    }

    public String getLatinKey() {
        return latinKey;
    }

    public String getShape() {
        return shape;
    }

    public byte getLocation() {
        return location;
    }

    public SplicingAtFrontRule getFuzzyFrontAtRule() {
        return fuzzyFrontAtRule;
    }

    public void setFuzzyFrontAtRule(SplicingAtFrontRule fuzzyFrontAtRule) {
        this.fuzzyFrontAtRule = fuzzyFrontAtRule;
    }

    public SplicingAtBehindRule getFuzzyBehindAtRule() {
        return fuzzyBehindAtRule;
    }

    public void setFuzzyBehindAtRule(SplicingAtBehindRule fuzzyBehindAtRule) {
        this.fuzzyBehindAtRule = fuzzyBehindAtRule;
    }

    public SplicingAtFrontRule getSevereFrontAtRule() {
        return severeFrontAtRule;
    }

    public void setSevereFrontAtRule(SplicingAtFrontRule severeFrontAtRule) {
        this.severeFrontAtRule = severeFrontAtRule;
    }

    public SplicingAtBehindRule getSevereBehindAtRule() {
        return severeBehindAtRule;
    }

    public void setSevereBehindAtRule(SplicingAtBehindRule severeBehindAtRule) {
        this.severeBehindAtRule = severeBehindAtRule;
    }

    public LetterShape newUnmodifiable() {
        return new UnmodifiableLetterShape(this);
    }
}
