package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class GaligZH extends Letter {
    public final LetterShape galigZhHead;

    public GaligZH() {
        super("galig_zh");
        galigZhHead = createGaligZhHead().newUnmodifiable();
    }

    private LetterShape createGaligZhHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.galig_tvvrai), LetterLocation.HEAD);
        return ls;
    }
}
