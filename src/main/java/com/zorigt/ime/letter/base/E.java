package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.FrontRuleHolder;

public class E extends Letter {
    public final LetterShape eHead;
    public final LetterShape eMiddle;
    public final LetterShape eTailOrhich;
    public final LetterShape eTailChachilga;
    public final LetterShape eTailVrvgsilga;


    public E() {
        super("e");
        eHead = createEHeadShape().newUnmodifiable();
        eMiddle = createEMiddleShape().newUnmodifiable();
        eTailOrhich = createETailOrhich().newUnmodifiable();
        eTailChachilga = createETailChachilga().newUnmodifiable();
        eTailVrvgsilga = createETailVrvgsilga().newUnmodifiable();
    }

    private LetterShape createEHeadShape() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.titem), LetterLocation.HEAD);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createEMiddleShape() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.achvg), LetterLocation.MIDDLE);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_MIDDLE_E);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createETailOrhich() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.orhich), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_ORHICH_E);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }

    private LetterShape createETailChachilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.vrvgsilga_or_chachilga), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_CHACHILGA_E);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }

    private LetterShape createETailVrvgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.achvg, ZCode.vrvgsilga_or_chachilga), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_VRVGSILGA_E);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }
}
