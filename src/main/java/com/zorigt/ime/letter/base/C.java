package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class C extends Letter {
    public final LetterShape cHead;
    public final LetterShape cMiddle;
    public final LetterShape cTail;

    public C() {
        super("c");
        cHead = createCHead().newUnmodifiable();
        cMiddle = createCMiddle().newUnmodifiable();
        cTail = createCTail().newUnmodifiable();
    }

    private LetterShape createCHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.c_acha), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createCMiddle() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.c_acha), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createCTail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.c_acha, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
