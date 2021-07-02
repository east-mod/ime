package com.zorigt.ime.letter.base;

import com.zorigt.ime.common.Strings;
import com.zorigt.ime.letter.Letter;
import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.ZCode;

@Deprecated
public class NG extends Letter {
    public final LetterShape ngMiddle;
    public final LetterShape ngTail;

    public NG() {
        super("ng");
        ngMiddle = createNgMiddle().newUnmodifiable();
        ngTail = createNgTail().newUnmodifiable();
    }

    private LetterShape createNgMiddle() {
        LetterShape ls = new LetterShape(latinKey,
                Strings.valueOf(ZCode.achvg, ZCode.silbi, ZCode.vrvgsilga_or_chachilga),
                LetterLocation.MIDDLE);

        return ls;
    }

    private LetterShape createNgTail() {
        LetterShape ls = new LetterShape(latinKey, Strings.valueOf(ZCode.achvg, ZCode.hinhir), LetterLocation.TAIL);

        return ls;
    }
}
