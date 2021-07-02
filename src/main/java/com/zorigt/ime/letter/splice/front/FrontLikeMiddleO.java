package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeMiddleO implements SplicingAtFrontRule {
    private final Set<LetterShape> notMatchShapes;

    public FrontLikeMiddleO() {
        this.notMatchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.notMatchShapes.isEmpty()) {
            return;
        }
        this.notMatchShapes.add(Letters.B.bHeadBanbvrBaga);
        this.notMatchShapes.add(Letters.B.bMiddleBanbvrBaga);
        this.notMatchShapes.add(Letters.P.pHeadChihiBaga);
        this.notMatchShapes.add(Letters.P.pMiddleChihiBaga);
        this.notMatchShapes.add(Letters.H.hHeadHinhir);
        this.notMatchShapes.add(Letters.H.hHeadHunhur);
        this.notMatchShapes.add(Letters.H.hMiddleHinhir);
        this.notMatchShapes.add(Letters.H.hMiddleHunhur);

        this.notMatchShapes.add(Letters.G.gHeadHinhir);
        this.notMatchShapes.add(Letters.G.gHeadHunhur);
        this.notMatchShapes.add(Letters.G.gMiddleHunhur);
        this.notMatchShapes.add(Letters.G.gMiddleHinhir);

        this.notMatchShapes.add(Letters.F.fHeadChihiBaga);
        this.notMatchShapes.add(Letters.F.fMiddleChihiBaga);
        this.notMatchShapes.add(Letters.K.kHeadBaga);
        this.notMatchShapes.add(Letters.K.kMiddleBaga);
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
