package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class GaligR extends Letter {
    public final LetterShape galigRHead;

    public GaligR() {
        super("galig_r");
        galigRHead = createGaligRHead().newUnmodifiable();
    }

    private LetterShape createGaligRHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.galig_r_malgai), LetterLocation.HEAD);
        return ls;
    }
}
