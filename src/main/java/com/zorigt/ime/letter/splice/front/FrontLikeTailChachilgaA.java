package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeTailChachilgaA implements SplicingAtFrontRule {
    private final Set<LetterShape> matchShapes;

    public FrontLikeTailChachilgaA() {
        this.matchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.matchShapes.isEmpty()) {
            return;
        }
        this.matchShapes.add(Letters.O.oMiddleBanbvrBaga);
        this.matchShapes.add(Letters.N.nMiddleNOrhich);
        this.matchShapes.add(Letters.H.hMiddleAgsilga);
        this.matchShapes.add(Letters.G.gMiddleDvsaltaiAgsilga);
        this.matchShapes.add(Letters.G.gMiddleAgsilga);
        this.matchShapes.add(Letters.M.mMiddleHurbelge);
        this.matchShapes.add(Letters.L.lMiddleHurbelge);
        this.matchShapes.add(Letters.Y.yMiddleHvms);
        this.matchShapes.add(Letters.R.rMiddleSuul);
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
