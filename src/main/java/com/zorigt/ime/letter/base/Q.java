package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class Q extends Letter {
    public final LetterShape qHead;
    public final LetterShape qMiddle;
    public final LetterShape qTail;

    public Q() {
        super("q");
        qHead = createQHead().newUnmodifiable();
        qMiddle = createQMiddle().newUnmodifiable();
        qTail = createQTail().newUnmodifiable();
    }

    private LetterShape createQHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.q_acha), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createQMiddle() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.q_acha), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createQTail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.q_acha, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
