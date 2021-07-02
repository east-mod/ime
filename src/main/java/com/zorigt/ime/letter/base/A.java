package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.FrontRuleHolder;

public class A extends Letter {
    public final LetterShape aHead;
    public final LetterShape aMiddle;
    public final LetterShape aTailOrhich;
    public final LetterShape aTailChachilga;
    public final LetterShape aTailVrvgsilga;

    public A() {
        super("a");
        aHead = createAHead().newUnmodifiable();
        aMiddle = createAMiddle().newUnmodifiable();
        aTailOrhich = createATailOrhich().newUnmodifiable();
        aTailChachilga = createATailChachilga().newUnmodifiable();
        aTailVrvgsilga = createATailVrvgsilga().newUnmodifiable();
    }

    private LetterShape createAHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.titem, ZCode.achvg), LetterLocation.HEAD);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);
        return ls;
    }

    private LetterShape createAMiddle() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.achvg), LetterLocation.MIDDLE);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_MIDDLE_A);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createATailOrhich() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.orhich), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_ORHICH_A);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }

    private LetterShape createATailChachilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.vrvgsilga_or_chachilga), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_CHACHILGA_A);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);
        return ls;
    }

    private LetterShape createATailVrvgsilga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.achvg, ZCode.vrvgsilga_or_chachilga), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_VRVGSILGA_A);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);
        return ls;
    }
}
