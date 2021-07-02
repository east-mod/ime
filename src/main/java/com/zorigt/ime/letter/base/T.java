package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class T extends Letter {
    public final LetterShape tHead;
    public final LetterShape tMiddleTSenj;
    public final LetterShape tMiddleDSenj;
    public final LetterShape tTail;

    public T() {
        super("t");
        tHead = createTHead().newUnmodifiable();
        tMiddleTSenj = createTMiddleTSenj().newUnmodifiable();
        tMiddleDSenj = createTMiddleDSenj().newUnmodifiable();
        tTail = createTTail().newUnmodifiable();
    }

    private LetterShape createTHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.t_senj), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createTMiddleTSenj() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.t_senj), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_NOT_EHSHIG);

        return ls;
    }

    private LetterShape createTMiddleDSenj() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.d_senj), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createTTail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.t_senj, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
