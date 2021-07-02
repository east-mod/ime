package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.FrontRuleHolder;

public class G extends Letter {
    public final LetterShape gHeadHanhar;
    public final LetterShape gHeadHinhir;
    public final LetterShape gHeadHunhur;

    public final LetterShape gMiddleHinhir;
    public final LetterShape gMiddleHunhur;
    public final LetterShape gMiddleDoubleNAchvg;
    public final LetterShape gMiddleDoubleAchvg;
    public final LetterShape gMiddleDoubleAchvgDagbvr;
    public final LetterShape gMiddleDvsaltaiAgsilga;
    public final LetterShape gMiddleAgsilga;

    public final LetterShape gTailAgsilga;
    public final LetterShape gTailSilbiVrvgsilga;

    public G() {
        super("g");
        gHeadHanhar = createGHeadHanhar().newUnmodifiable();
        gHeadHinhir = createGHeadHinhir().newUnmodifiable();
        gHeadHunhur = createGHeadHunhur().newUnmodifiable();

        gMiddleHinhir = createGMiddleHinhir().newUnmodifiable();
        gMiddleHunhur = createGMiddleHunhur().newUnmodifiable();
        gMiddleDoubleNAchvg = createGMiddleDoubleNAchvg().newUnmodifiable();
        gMiddleDoubleAchvg = createGMiddleDoubleAchvg().newUnmodifiable();
        gMiddleDoubleAchvgDagbvr = createGMiddleDoubleAchvgDagbvr().newUnmodifiable();
        gMiddleDvsaltaiAgsilga = createGMiddleDvsaltaiAgsilga().newUnmodifiable();
        gMiddleAgsilga = createGMiddleAgsilga().newUnmodifiable();

        gTailAgsilga = createGTailAgsilga().newUnmodifiable();
        gTailSilbiVrvgsilga = createGTailSilbiVrvgsilga().newUnmodifiable();
    }

    private LetterShape createGHeadHanhar() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.g_hanhar), LetterLocation.HEAD);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_CHINGA_EHSHIG);

        return ls;
    }

    private LetterShape createGHeadHinhir() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hinhir), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createGHeadHunhur() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hunhur), LetterLocation.HEAD);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createGMiddleHinhir() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hinhir), LetterLocation.MIDDLE);

//        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_NOT_CHIGA_SEQUENCE);

        return ls;
    }

    private LetterShape createGMiddleHunhur() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hunhur), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createGMiddleDoubleNAchvg() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.n_achvg, ZCode.n_achvg), LetterLocation.MIDDLE);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_NOT_MIDDLE_SD);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_CHINGA_EHSHIG);

        return ls;
    }

    private LetterShape createGMiddleDoubleAchvg() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.achvg, ZCode.achvg), LetterLocation.MIDDLE);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_MIDDLE_SD);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_CHINGA_EHSHIG);

        return ls;
    }

    private LetterShape createGMiddleDoubleAchvgDagbvr() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.achvg, ZCode.achvg), LetterLocation.MIDDLE);

//        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_CHIGA_SEQUENCE);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_NOT_EHSHIG);

        return ls;
    }

    private LetterShape createGMiddleDvsaltaiAgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.dvsaltai_agsilga), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_NOT_MIDDLE_SD);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_A_CHACHILGA);

        return ls;
    }

    private LetterShape createGMiddleAgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.agsilga), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_MIDDLE_SD);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_A_CHACHILGA);

        return ls;
    }

    private LetterShape createGTailAgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.agsilga), LetterLocation.TAIL);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_CHIGA_SEQUENCE);

        return ls;
    }

    private LetterShape createGTailSilbiVrvgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.silbi, ZCode.vrvgsilga_or_chachilga), LetterLocation.TAIL);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_NOT_CHIGA_SEQUENCE);

        return ls;
    }
}
