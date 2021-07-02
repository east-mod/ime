package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

public class GaligL extends Letter {
    public final LetterShape galigLHead;

    public GaligL() {
        super("galig_l");
        galigLHead = createGaligLHead().newUnmodifiable();
    }

    private LetterShape createGaligLHead() {
        LetterShape ls = new LetterShape(
                latinKey, Strings.valueOf(ZCode.l_titem, ZCode.galig_tvvrai), LetterLocation.HEAD);
        return ls;
    }
}
