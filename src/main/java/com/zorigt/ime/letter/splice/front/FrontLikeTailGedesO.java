package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeTailGedesO implements SplicingAtFrontRule {
    private final Set<LetterShape> matchShapes;

    public FrontLikeTailGedesO() {
        this.matchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.matchShapes.isEmpty()) {
            return;
        }
        this.matchShapes.add(Letters.B.bHeadBanbvrIh);
        this.matchShapes.add(Letters.B.bMiddleBanbvrIh);
        this.matchShapes.add(Letters.P.pHeadChihiIh);
        this.matchShapes.add(Letters.P.pMiddleChihiIh);
        this.matchShapes.add(Letters.F.fHeadChihiIh);
        this.matchShapes.add(Letters.F.fMiddleChihiIh);
        this.matchShapes.add(Letters.K.kHeadIh);
        this.matchShapes.add(Letters.K.kMiddleIh);
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
