package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class W extends Letter {
    public final LetterShape wHead;
    public final LetterShape wMiddle;
    public final LetterShape wTail;

    public W() {
        super("w");
        wHead = createWHead().newUnmodifiable();
        wMiddle = createWMiddle().newUnmodifiable();
        wTail = createWTail().newUnmodifiable();
    }

    private LetterShape createWHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.w_gohtai_silbi), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createWMiddle() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.w_gohtai_silbi), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createWTail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.w_gohtai_silbi, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
