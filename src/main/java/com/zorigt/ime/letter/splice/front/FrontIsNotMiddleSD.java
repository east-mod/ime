package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

public class FrontIsNotMiddleSD implements SplicingAtFrontRule {
    @Override
    public boolean match(LetterShapeSequence lss) {
        if (lss.isEmpty()) {
            return false;
        }
        LetterShape last = lss.getLast();
        if (last == null) {
            return false;
        }
        return !last.equals(Letters.S.sMiddle) &&
                !last.equals(Letters.D.dMiddleGedesAchvg);
    }
}
