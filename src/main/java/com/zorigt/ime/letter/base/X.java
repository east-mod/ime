package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class X extends Letter {
    public final LetterShape xHead;
    public final LetterShape xMidddle;
    public final LetterShape xTail;

    public X() {
        super("x");
        xHead = createXHead().newUnmodifiable();
        xMidddle = createXMiddle().newUnmodifiable();
        xTail = createXTail().newUnmodifiable();
    }

    private LetterShape createXHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.x_sechig), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createXMiddle() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.x_sechig), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createXTail() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.x_agshilga), LetterLocation.TAIL);
        return ls;
    }
}
