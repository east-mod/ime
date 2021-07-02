package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

public class FrontEmpty implements SplicingAtFrontRule {
    @Override
    public boolean match(LetterShapeSequence lss) {
        return lss.isEmpty();
    }
}
