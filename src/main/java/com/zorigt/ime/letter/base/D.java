package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;
import com.zorigt.ime.letter.splice.BehindRuleHolder;

public class D extends Letter {
    public final LetterShape dHeadTSenj;
    public final LetterShape dHeadDSenj;
    public final LetterShape dMiddleDSenj;
    public final LetterShape dMiddleGedesAchvg;
    public final LetterShape dTailGedesOrhich;
    public final LetterShape dTailDSenjSuul1;

    public D() {
        super("d");
        dHeadTSenj = createDHeadTSenj().newUnmodifiable();
        dHeadDSenj = createDHeadDSenj().newUnmodifiable();
        dMiddleDSenj = createDMiddleDSenj().newUnmodifiable();
        dMiddleGedesAchvg = createDMiddleGedesAchvg().newUnmodifiable();
        dTailGedesOrhich = createDTailGedesOrhich().newUnmodifiable();
        dTailDSenjSuul1 = createDTailDSenjSuul1().newUnmodifiable();
    }

    private LetterShape createDHeadTSenj() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.t_senj), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createDHeadDSenj() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.d_senj), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createDMiddleDSenj() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.d_senj), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_EHSHIG);

        return ls;
    }

    private LetterShape createDMiddleGedesAchvg() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes, ZCode.achvg), LetterLocation.MIDDLE);

        ls.setSevereBehindAtRule(BehindRuleHolder.BEHIND_IS_NOT_EHSHIG);

        return ls;
    }

    private LetterShape createDTailGedesOrhich() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes, ZCode.orhich), LetterLocation.TAIL);
        return ls;
    }

    private LetterShape createDTailDSenjSuul1() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.d_senj, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
