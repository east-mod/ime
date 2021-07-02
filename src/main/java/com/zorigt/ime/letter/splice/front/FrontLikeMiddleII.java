package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeMiddleII implements SplicingAtFrontRule {
    private final Set<LetterShape> matchShapes;

    public FrontLikeMiddleII() {
        this.matchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.matchShapes.isEmpty()) {
            return;
        }
        this.matchShapes.add(Letters.A.aHead);
        this.matchShapes.add(Letters.A.aMiddle);
        this.matchShapes.add(Letters.E.eHead);
        this.matchShapes.add(Letters.E.eMiddle);
//        this.matchShapes.add(Letters.O.oHeadGedes);
        this.matchShapes.add(Letters.O.oHeadTitemGedes);
        this.matchShapes.add(Letters.O.oMiddleGedes);
    }

    @Override
    public boolean match(LetterShapeSequence lss) {
        this.init();
        if (lss.isEmpty()) {
            return false;
        }
        LetterShape last = lss.getLast();
        if (last == null) {
            return false;
        }
        return this.matchShapes.contains(last);
    }
}
