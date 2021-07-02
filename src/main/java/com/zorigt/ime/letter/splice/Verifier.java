package com.zorigt.ime.letter.splice;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;

public class Verifier {

    public static boolean canFuzzySplicing(LetterShapeSequence lss, LetterShape ls) {
        if (ls.getFuzzyFrontAtRule() != null && !ls.getFuzzyFrontAtRule().match(lss)) {
            return false;
        }
        if (lss.isNotEmpty()) {
            LetterShape last = lss.getLast();
            return last.getFuzzyBehindAtRule() == null || last.getFuzzyBehindAtRule().match(ls);
        }
        return true;
    }

    public static boolean canSevereSplicing(LetterShapeSequence lss, LetterShape ls) {
        if (ls.getSevereFrontAtRule() != null && !ls.getSevereFrontAtRule().match(lss)) {
            return false;
        }
        if (lss.isNotEmpty()) {
            LetterShape last = lss.getLast();
            return last.getSevereBehindAtRule() == null || last.getSevereBehindAtRule().match(ls);
        }
        return true;
    }

}
