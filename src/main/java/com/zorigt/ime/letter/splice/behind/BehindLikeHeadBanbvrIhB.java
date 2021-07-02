package com.zorigt.ime.letter.splice.behind;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtBehindRule;

import java.util.HashSet;
import java.util.Set;

public class BehindLikeHeadBanbvrIhB implements SplicingAtBehindRule {
    private final Set<LetterShape> matchShapes = new HashSet<>(16);

    private void init() {
        if (!matchShapes.isEmpty()) {
            return;
        }
        matchShapes.add(Letters.O.oMiddleGedes);
        matchShapes.add(Letters.O.oTailGedes);
        matchShapes.add(Letters.U.uMiddleGedes);
        matchShapes.add(Letters.U.uMiddleGedesSilbi);
        matchShapes.add(Letters.U.uTailGedes);
        matchShapes.add(Letters.U.uTailGedesSuul1);
    }

    @Override
    public boolean match(LetterShape ls) {
        init();
        if (ls == null) {
            return false;
        }
        return matchShapes.contains(ls);
    }
}
