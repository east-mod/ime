package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class S extends Letter {
    public final LetterShape sHead;
    public final LetterShape sMiddle;
    public final LetterShape sTail;

    public S() {
        super("s");
        sHead = createSHead().newUnmodifiable();
        sMiddle = createSMiddle().newUnmodifiable();
        sTail = createSTail().newUnmodifiable();
    }

    private LetterShape createSHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.s_sechig), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createSMiddle() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.s_sechig), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createSTail() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.s_agshilga), LetterLocation.TAIL);
        return ls;
    }
}
