package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class GaligH extends Letter {
    public final LetterShape galigHHead;
    public final LetterShape galigHMiddle;

    public GaligH() {
        super("galig_h");
        galigHHead = createGaligHHead().newUnmodifiable();
        galigHMiddle = createGaligHMiddle().newUnmodifiable();
    }

    private LetterShape createGaligHHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.titem, ZCode.galig_tvvrai), LetterLocation.HEAD);
        return ls;
    }

    private LetterShape createGaligHMiddle() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.galig_tvvrai), LetterLocation.MIDDLE);
        return ls;
    }
}
