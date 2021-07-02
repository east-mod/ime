package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class P extends Letter {
    public final LetterShape pHeadChihiBaga;
    public final LetterShape pHeadChihiIh;
    public final LetterShape pMiddleChihiBaga;
    public final LetterShape pMiddleChihiIh;
    public final LetterShape pTailChihiEgsilge;

    public P() {
        super("p");
        pHeadChihiBaga = createPHeadChihiBaga().newUnmodifiable();
        pHeadChihiIh = createPHeadChihiIh().newUnmodifiable();
        pMiddleChihiBaga = createPMiddleChihiBaga().newUnmodifiable();
        pMiddleChihiIh = createPMiddleChihiIh().newUnmodifiable();
        pTailChihiEgsilge = createPTailChihiEgsilge().newUnmodifiable();
    }

    private LetterShape createPHeadChihiBaga() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.p_chihi_baga), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createPHeadChihiIh() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.p_chihi_ih), LetterLocation.HEAD);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createPMiddleChihiBaga() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.p_chihi_baga), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createPMiddleChihiIh() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.p_chihi_ih), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createPTailChihiEgsilge() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.p_chihi_egsilge), LetterLocation.TAIL);
        return ls;
    }
}
