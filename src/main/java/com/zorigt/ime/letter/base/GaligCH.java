package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class GaligCH extends Letter {
    public final LetterShape galigChHead;

    public GaligCH() {
        super("galig_ch");
        galigChHead = createGaligChHead().newUnmodifiable();
    }

    private LetterShape createGaligChHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.gedes, ZCode.gedes), LetterLocation.HEAD);
        return ls;
    }
}
