package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class R extends Letter {
    public final LetterShape rHead;
    public final LetterShape rMiddleErbgeljinSilbi;
    public final LetterShape rMiddleSuul;
    public final LetterShape rTail;

    public R() {
        super("r");
        rHead = createRHead().newUnmodifiable();
        rMiddleErbgeljinSilbi = createRMiddleErbgeljinSilbi().newUnmodifiable();
        rMiddleSuul = createRMiddleSuul().newUnmodifiable();
        rTail = createRTail().newUnmodifiable();
    }

    private LetterShape createRHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.r_erbgeljin_silbi), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createRMiddleErbgeljinSilbi() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.r_erbgeljin_silbi), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createRMiddleSuul() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.r_suul), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        return ls;
    }

    private LetterShape createRTail() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.r_suul), LetterLocation.TAIL);
        return ls;
    }
}
