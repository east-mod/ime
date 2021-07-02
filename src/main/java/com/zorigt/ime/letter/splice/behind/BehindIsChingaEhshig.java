package com.zorigt.ime.letter.splice.behind;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtBehindRule;

public class BehindIsChingaEhshig implements SplicingAtBehindRule {
    @Override
    public boolean match(LetterShape ls) {
        if (ls == null) {
            return false;
        }
        return ls.getLatinKey().equals(Letters.A.getLatinKey()) ||
                ls.getLatinKey().equals(Letters.O.getLatinKey());
    }
}
