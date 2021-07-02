package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class K extends Letter {
    public final LetterShape kHeadBaga;
    public final LetterShape kHeadIh;
    public final LetterShape kMiddleBaga;
    public final LetterShape kMiddleIh;
    public final LetterShape kTailEgsilge;

    public K() {
        super("k");
        kHeadBaga = createKHeadBaga().newUnmodifiable();
        kHeadIh = createKHeadIh().newUnmodifiable();
        kMiddleBaga = createKMiddleBaga().newUnmodifiable();
        kMiddleIh = createKMiddleIh().newUnmodifiable();
        kTailEgsilge = createKTailEgsilge().newUnmodifiable();
    }

    private LetterShape createKHeadBaga() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.k_baga), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createKHeadIh() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.k_ih), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createKMiddleBaga() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.k_baga), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createKMiddleIh() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.k_ih), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createKTailEgsilge() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.k_egsilge), LetterLocation.TAIL);
        return ls;
    }
}
