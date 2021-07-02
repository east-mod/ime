package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.FrontRuleHolder;

public class O extends Letter {
    public final LetterShape oHeadTitemGedes;
    public final LetterShape oHeadGedes;
    public final LetterShape oMiddleGedes;
    public final LetterShape oMiddleBanbvrBaga;
    public final LetterShape oTailGedes;
    public final LetterShape oTailBanbvrBaga;

    public O() {
        super("o");
        oHeadTitemGedes = createOHeadTitemGedes().newUnmodifiable();
        oHeadGedes = createOHeadGedes().newUnmodifiable();
        oMiddleGedes = createOMiddleGedes().newUnmodifiable();
        oMiddleBanbvrBaga = createOMiddleBanbvrBaga().newUnmodifiable();
        oTailGedes = createOTailGedes().newUnmodifiable();
        oTailBanbvrBaga = createOTailBanbvrBaga().newUnmodifiable();
    }

    private LetterShape createOHeadTitemGedes() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.titem, ZCode.gedes), LetterLocation.HEAD);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createOHeadGedes() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes), LetterLocation.HEAD);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createOMiddleGedes() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes), LetterLocation.MIDDLE);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_MIDDLE_O);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createOMiddleBanbvrBaga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.b_banbvr_baga), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_LIKE_MIDDLE_BANBVR_BAGA_O);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_BANBVR_BAGA);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_MIDDLE_BANBVR_BAGA_O);

        return ls;
    }

    private LetterShape createOTailGedes() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_GEDES_O);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }

    private LetterShape createOTailBanbvrBaga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.b_banbvr_baga), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_BANBVR_BAGA);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }
}
