package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class F extends Letter {
    public final LetterShape fHeadChihiBaga;
    public final LetterShape fHeadChihiIh;
    public final LetterShape fMiddleChihiBaga;
    public final LetterShape fMiddleChihiIh;
    public final LetterShape fTailChihiEgsilge;

    public F() {
        super("f");
        fHeadChihiBaga = createFHeadChihiBaga().newUnmodifiable();
        fHeadChihiIh = createFHeadChihiIh().newUnmodifiable();
        fMiddleChihiBaga = createFMiddleChihiBaga().newUnmodifiable();
        fMiddleChihiIh = createFMiddleChihiIh().newUnmodifiable();
        fTailChihiEgsilge = createFTailChihiEgsilge().newUnmodifiable();
    }

    private LetterShape createFHeadChihiBaga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.f_chihi_baga), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createFHeadChihiIh() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.f_chihi_ih), LetterLocation.HEAD);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createFMiddleChihiBaga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.f_chihi_baga), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createFMiddleChihiIh() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.f_chihi_ih), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createFTailChihiEgsilge() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.f_chihi_egsilge), LetterLocation.TAIL);
        return ls;
    }
}
