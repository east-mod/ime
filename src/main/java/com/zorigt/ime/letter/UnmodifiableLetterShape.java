package com.zorigt.ime.letter;

import com.zorigt.ime.letter.splice.SplicingAtBehindRule;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

public class UnmodifiableLetterShape extends LetterShape {

    public UnmodifiableLetterShape(LetterShape letterShape) {
        super(letterShape.latinKey, letterShape.shape, letterShape.location);
        this.fuzzyFrontAtRule = letterShape.fuzzyFrontAtRule;
        this.fuzzyBehindAtRule = letterShape.fuzzyBehindAtRule;
        this.severeFrontAtRule = letterShape.severeFrontAtRule;
        this.severeBehindAtRule = letterShape.severeBehindAtRule;
    }

    @Override
    public void setFuzzyFrontAtRule(SplicingAtFrontRule fuzzyFrontAtRule) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setFuzzyBehindAtRule(SplicingAtBehindRule fuzzyBehindAtRule) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSevereFrontAtRule(SplicingAtFrontRule severeFrontAtRule) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setSevereBehindAtRule(SplicingAtBehindRule severeBehindAtRule) {
        throw new UnsupportedOperationException();
    }
}
