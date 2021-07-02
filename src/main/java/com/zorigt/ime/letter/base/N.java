package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class N extends Letter {
    public final LetterShape nHead;
    public final LetterShape nMiddleNAchvg;
    public final LetterShape nMiddleNOrhich;
    public final LetterShape nMiddleAchvg;
    public final LetterShape nTailOrhich;

    public N() {
        super("n");
        nHead = createNHead().newUnmodifiable();
        nMiddleNAchvg = createNMiddleNAchvg().newUnmodifiable();
        nMiddleNOrhich = createNMiddleNOrhich().newUnmodifiable();
        nMiddleAchvg = createNMiddleAchvg().newUnmodifiable();
        nTailOrhich = createNTailOrhich().newUnmodifiable();
    }

    private LetterShape createNHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.n_titem), LetterLocation.HEAD);

        return ls;
    }

    private LetterShape createNMiddleNAchvg() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.n_achvg), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_EHSHIG);

        return ls;
    }

    private LetterShape createNMiddleNOrhich() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.n_orhich), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        return ls;
    }

    private LetterShape createNMiddleAchvg() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.achvg), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_NOT_EHSHIG);

        return ls;
    }

    private LetterShape createNTailOrhich() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.orhich), LetterLocation.TAIL);

        return ls;
    }
}
