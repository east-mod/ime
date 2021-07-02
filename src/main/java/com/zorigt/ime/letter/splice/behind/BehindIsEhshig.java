package com.zorigt.ime.letter.splice.behind;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtBehindRule;

import java.util.HashSet;
import java.util.Set;

public class BehindIsEhshig implements SplicingAtBehindRule {
    private final Set<String> matchLetters = new HashSet<>(16);

    private void init() {
        if (!matchLetters.isEmpty()) {
            return;
        }
        matchLetters.add(Letters.A.getLatinKey());
        matchLetters.add(Letters.E.getLatinKey());
        matchLetters.add(Letters.I.getLatinKey());
        matchLetters.add(Letters.O.getLatinKey());
        matchLetters.add(Letters.U.getLatinKey());
    }

    @Override
    public boolean match(LetterShape ls) {
        init();
        if (ls == null) {
            return false;
        }
        return matchLetters.contains(ls.getLatinKey());
    }
}
