package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeMiddleA implements SplicingAtFrontRule {
    private final Set<LetterShape> notMatchShapes;

    public FrontLikeMiddleA() {
        this.notMatchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.notMatchShapes.isEmpty()) {
            return;
        }
        this.notMatchShapes.add(Letters.B.bHeadBanbvrIh);
        this.notMatchShapes.add(Letters.B.bMiddleBanbvrIh);
        this.notMatchShapes.add(Letters.P.pHeadChihiIh);
        this.notMatchShapes.add(Letters.P.pMiddleChihiIh);
        this.notMatchShapes.add(Letters.H.hHeadHunhur);
        this.notMatchShapes.add(Letters.H.hMiddleHunhur);
        this.notMatchShapes.add(Letters.H.hHeadHinhir);
        this.notMatchShapes.add(Letters.H.hMiddleHinhir);
        this.notMatchShapes.add(Letters.G.gHeadHunhur);
        this.notMatchShapes.add(Letters.G.gHeadHinhir);
        this.notMatchShapes.add(Letters.G.gMiddleHinhir);
        this.notMatchShapes.add(Letters.G.gMiddleHunhur);
        this.notMatchShapes.add(Letters.F.fHeadChihiIh);
        this.notMatchShapes.add(Letters.F.fMiddleChihiIh);
        this.notMatchShapes.add(Letters.K.kHeadIh);
        this.notMatchShapes.add(Letters.K.kMiddleIh);
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
        return !this.notMatchShapes.contains(last);
    }
}
