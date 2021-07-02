package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class L extends Letter {
    public final LetterShape lHead;
    public final LetterShape lMiddleAchvg;
    public final LetterShape lMiddleHurbelge;
    public final LetterShape lTailHurbelge;

    public L() {
        super("l");
        lHead = createLHead().newUnmodifiable();
        lMiddleAchvg = createLMiddleAchvg().newUnmodifiable();
        lMiddleHurbelge = createLMiddleHurbelge().newUnmodifiable();
        lTailHurbelge = createLTailHurbelge().newUnmodifiable();
    }

    private LetterShape createLHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.l_titem), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createLMiddleAchvg() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.l_achvg), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createLMiddleHurbelge() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.l_hurbelge), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        return ls;
    }

    private LetterShape createLTailHurbelge() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.l_hurbelge), LetterLocation.TAIL);
        return ls;
    }
}
