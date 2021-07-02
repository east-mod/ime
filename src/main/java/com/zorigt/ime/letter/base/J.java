package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class J extends Letter {
    public final LetterShape jHead;
    public final LetterShape jMiddle;
    public final LetterShape jTail;

    public J() {
        super("j");
        jHead = createJHead().newUnmodifiable();
        jMiddle = createJMiddle().newUnmodifiable();
        jTail = createJTail().newUnmodifiable();
    }

    private LetterShape createJHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.silbi), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createJMiddle() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.j_bosoo_silbi), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createJTail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.j_bosoo_silbi, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
