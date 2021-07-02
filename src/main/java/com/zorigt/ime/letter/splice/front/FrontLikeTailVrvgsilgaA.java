package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeTailVrvgsilgaA implements SplicingAtFrontRule {
    private final Set<LetterShape> matchShapes;

    public FrontLikeTailVrvgsilgaA() {
        this.matchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.matchShapes.isEmpty()) {
            return;
        }
        this.matchShapes.add(Letters.B.bHeadBanbvrBaga);
        this.matchShapes.add(Letters.B.bMiddleBanbvrBaga);
        this.matchShapes.add(Letters.P.pHeadChihiBaga);
        this.matchShapes.add(Letters.P.pMiddleChihiBaga);
        this.matchShapes.add(Letters.F.fHeadChihiBaga);
        this.matchShapes.add(Letters.F.fMiddleChihiBaga);
        this.matchShapes.add(Letters.K.kHeadBaga);
        this.matchShapes.add(Letters.K.kMiddleBaga);
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
