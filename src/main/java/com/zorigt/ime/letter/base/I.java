package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.FrontRuleHolder;

public class I extends Letter {
    public final LetterShape iHead;
    public final LetterShape iiHead;
    public final LetterShape iMiddle;
    public final LetterShape iiMiddle;
    public final LetterShape iTail;
    public final LetterShape iTailSilbiSuul1;

    public I() {
        super("i");
        iHead = createIhead().newUnmodifiable();
        iMiddle = createIMiddle().newUnmodifiable();
        iTail = createITail().newUnmodifiable();
        iTailSilbiSuul1 = createITailSilbiSuul1().newUnmodifiable();

        iiHead = createIIHead().newUnmodifiable();
        iiMiddle = createIIMiddle().newUnmodifiable();
    }

    private LetterShape createIhead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.titem, ZCode.silbi), LetterLocation.HEAD);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createIIHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.silbi, ZCode.silbi), LetterLocation.HEAD);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_EMPTY);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createIMiddle() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.silbi), LetterLocation.MIDDLE);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_MIDDLE_I);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createIIMiddle() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.silbi, ZCode.silbi), LetterLocation.MIDDLE);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(null);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_MIDDLE_II);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_NOT_EMPTY);

        return ls;
    }

    private LetterShape createITail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hvms), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_HVMS_I);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }

    private LetterShape createITailSilbiSuul1() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.silbi, ZCode.suul1), LetterLocation.TAIL);

        ls.setFuzzyFrontAtRule(FrontRuleHolder.FRONT_NOT_EMPTY);
        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        ls.setSevereFrontAtRule(FrontRuleHolder.FRONT_LIKE_TAIL_SILBI_SUUL_1_I);
        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_EMPTY);

        return ls;
    }
}
