package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class B extends Letter {
    public final LetterShape bHeadBanbvrBaga;
    public final LetterShape bHeadBanbvrIh;
    public final LetterShape bMiddleBanbvrBaga;
    public final LetterShape bMiddleBanbvrIh;
    public final LetterShape bTailBanbvrEgsilge;

    public B() {
        super("b");
        bHeadBanbvrBaga = createBHeadBanbvrBaga().newUnmodifiable();
        bHeadBanbvrIh = createBHeadBanbvrIh().newUnmodifiable();
        bMiddleBanbvrBaga = createBMiddleBanbvrBaga().newUnmodifiable();
        bMiddleBanbvrIh = createBMiddleBanbvrIh().newUnmodifiable();
        bTailBanbvrEgsilge = createBTailBanbvrEgsilge().newUnmodifiable();
    }

    private LetterShape createBHeadBanbvrBaga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf((ZCode.b_banbvr_baga)), LetterLocation.HEAD);

        return ls;
    }

    private LetterShape createBHeadBanbvrIh() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf((ZCode.b_banbvr_ih)), LetterLocation.HEAD);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createBMiddleBanbvrBaga() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf((ZCode.b_banbvr_baga)), LetterLocation.MIDDLE);

        return ls;
    }

    private LetterShape createBMiddleBanbvrIh() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf((ZCode.b_banbvr_ih)), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_LIKE_HEAD_BANBVR_IH_B);

        return ls;
    }

    private LetterShape createBTailBanbvrEgsilge() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf((ZCode.b_banbvr_egsilge)), LetterLocation.TAIL);

        return ls;
    }
}
