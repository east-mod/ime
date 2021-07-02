package com.zorigt.ime.letter.splice.behind;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.splice.SplicingAtBehindRule;

public class BehindEmpty implements SplicingAtBehindRule {
    @Override
    public boolean match(LetterShape ls) {
        return ls == null;
    }
}
