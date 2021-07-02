package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class Z extends Letter {
    public final LetterShape zHead;
    public final LetterShape zMiddle;
    public final LetterShape zTail;

    public Z() {
        super("z");
        zHead = createZHead().newUnmodifiable();
        zMiddle = createZMiddle().newUnmodifiable();
        zTail = createZTail().newUnmodifiable();
    }

    private LetterShape createZHead() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.z_acha), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createZMiddle() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.z_acha), LetterLocation.MIDDLE);
        return ls;
    }

    private LetterShape createZTail() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.z_acha, ZCode.suul1), LetterLocation.TAIL);
        return ls;
    }
}
