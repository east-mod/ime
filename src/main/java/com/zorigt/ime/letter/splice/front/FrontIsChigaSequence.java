package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Nature;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

public class FrontIsChigaSequence implements SplicingAtFrontRule {
    @Override
    public boolean match(LetterShapeSequence lss) {
        if (lss.isEmpty()) {
            return false;
        }
        return lss.getNature() == Nature.CHAGH;
    }
}
