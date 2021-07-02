package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.FrontRuleHolder;

public class U extends Letter {
    public final LetterShape uHead;
    public final LetterShape uMiddleGedesSilbi;
    public final LetterShape uMiddleGedes;
    public final LetterShape uTailGedes;
    public final LetterShape uTailBanbvrBaga;
    public final LetterShape uTailGedesSuul1;

    public U() {
        super("u");
        uHead = createUHead().newUnmodifiable();
        uMiddleGedesSilbi = createUMiddleGedesSilbi().newUnmodifiable();
        uMiddleGedes = createUMiddleGedes().newUnmodifiable();
        uTailGedes = createUTailGedes().newUnmodifiable();
        uTailBanbvrBaga = createUTailBanbvrBaga().newUnmodifiable();
        uTailGedesSuul1 = createUTailGedesSuul1().newUnmodifiable();
    }

    private LetterShape createUHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.titem, ZCode.gedes, ZCode.silbi), LetterLocation.HEAD);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createUMiddleGedesSilbi() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes, ZCode.silbi), LetterLocation.MIDDLE);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_MIDDLE_GEDES_SILBI_U);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createUMiddleGedes() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.gedes), LetterLocation.MIDDLE);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_MIDDLE_GEDES_U);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createUTailGedes() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.gedes), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_GEDES_U);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }

    private LetterShape createUTailBanbvrBaga() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.b_banbvr_baga), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_BANBVR_BAGA_U);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }

    private LetterShape createUTailGedesSuul1() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes, ZCode.suul1), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_TAIL_GEDES_SUUL1_U);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }
}
