package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.FrontRuleHolder;

public class H extends Letter {
    public final LetterShape hHeadHanhar;
    public final LetterShape hHeadHinhir;
    public final LetterShape hHeadHunhur;

    public final LetterShape hMiddleHinhir;
    public final LetterShape hMiddleHunhur;
    public final LetterShape hMiddleDoubleAchvg;
    public final LetterShape hMiddleAgsilga;

    public final LetterShape hTailAgsilga;
    public final LetterShape hTailSilbiVrvgsilga;

    public H() {
        super("h");
        hHeadHanhar = createHHeadHanhar().newUnmodifiable();
        hHeadHinhir = createHHeadHinhir().newUnmodifiable();
        hHeadHunhur = createHHeadHunhur().newUnmodifiable();

        hMiddleHinhir = createHMiddleHinhir().newUnmodifiable();
        hMiddleHunhur = createHMiddleHunhur().newUnmodifiable();
        hMiddleDoubleAchvg = createHMiddleDoubleAchvg().newUnmodifiable();
        hMiddleAgsilga = createHMiddleAgsilga().newUnmodifiable();

        hTailAgsilga = createHTailAgsilga().newUnmodifiable();
        hTailSilbiVrvgsilga = createHTailSilbiVrvgsilga().newUnmodifiable();
    }

    private LetterShape createHHeadHanhar() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.h_hanhar), LetterLocation.HEAD);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_CHINGA_EHSHIG);

        return ls;
    }

    private LetterShape createHHeadHinhir() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hinhir), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createHHeadHunhur() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hunhur), LetterLocation.HEAD);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createHMiddleHinhir() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hinhir), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createHMiddleHunhur() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hunhur), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createHMiddleDoubleAchvg() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.achvg, ZCode.achvg), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_CHINGA_EHSHIG);

        return ls;
    }

    private LetterShape createHMiddleAgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.agsilga), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_A_CHACHILGA);

        return ls;
    }

    private LetterShape createHTailAgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.agsilga), LetterLocation.TAIL);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_CHIGA_SEQUENCE);

        return ls;
    }

    private LetterShape createHTailSilbiVrvgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.silbi, ZCode.vrvgsilga_or_chachilga), LetterLocation.TAIL);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_IS_NOT_CHIGA_SEQUENCE);

        return ls;
    }

}
