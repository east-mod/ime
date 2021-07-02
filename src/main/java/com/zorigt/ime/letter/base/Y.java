package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class Y extends Letter {
    public final LetterShape yHead;
    public final LetterShape yMiddleErtegerSilbi;
    public final LetterShape yMiddleHvms;
    public final LetterShape yTail;

    public Y() {
        super("y");
        yHead = createYHead().newUnmodifiable();
        yMiddleErtegerSilbi = createYMiddleErtegerSilbi().newUnmodifiable();
        yMiddleHvms = createYMiddleHvms().newUnmodifiable();
        yTail = createYTail().newUnmodifiable();
    }

    private LetterShape createYHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.y_erteger_silbi), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createYMiddleErtegerSilbi() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.y_erteger_silbi), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createYMiddleHvms() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.hvms), LetterLocation.MIDDLE);

        ls.setFuzzyBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_AE_CHACHILGA);

        return ls;
    }

    private LetterShape createYTail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.y_erteger_silbi, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
