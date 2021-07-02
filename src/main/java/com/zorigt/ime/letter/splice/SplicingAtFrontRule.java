package com.zorigt.ime.letter.splice;

import com.zorigt.ime.letter.LetterShapeSequence;

public interface SplicingAtFrontRule {
    boolean match(LetterShapeSequence lss);
}
