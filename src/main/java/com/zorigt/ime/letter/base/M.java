package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class M extends Letter {
    public final LetterShape mHead;
    public final LetterShape mMiddleAchvg;
    public final LetterShape mMiddleHurbelge;
    public final LetterShape mTailHurbelge;

    public M() {
        super("m");
        mHead = createMHead().newUnmodifiable();
        mMiddleAchvg = createMMiddleAchvg().newUnmodifiable();
        mMiddleHurbelge = createMMiddleHurbelge().newUnmodifiable();
        mTailHurbelge = createMTailHurbelge().newUnmodifiable();
    }

    private LetterShape createMHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.m_titem), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createMMiddleAchvg() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.m_achvg), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createMMiddleHurbelge() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.m_hurbelge), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        return ls;
    }

    private LetterShape createMTailHurbelge() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.m_hurbelge), LetterLocation.TAIL);
        return ls;
    }
}
