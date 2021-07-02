package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeMiddleI implements SplicingAtFrontRule {
    private final Set<LetterShape> notMatchShapes;

    public FrontLikeMiddleI() {
        this.notMatchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.notMatchShapes.isEmpty()) {
            return;
        }
        this.notMatchShapes.add(Letters.A.aHead);
        this.notMatchShapes.add(Letters.A.aMiddle);
        this.notMatchShapes.add(Letters.E.eHead);
        this.notMatchShapes.add(Letters.E.eMiddle);
//        this.notMatchShapes.add(Letters.O.oHeadGedes);
        this.notMatchShapes.add(Letters.O.oHeadTitemGedes);
        this.notMatchShapes.add(Letters.O.oMiddleGedes);
        this.notMatchShapes.add(Letters.U.uMiddleGedes);
        this.notMatchShapes.add(Letters.B.bHeadBanbvrIh);
        this.notMatchShapes.add(Letters.B.bMiddleBanbvrIh);
        this.notMatchShapes.add(Letters.P.pHeadChihiIh);
        this.notMatchShapes.add(Letters.P.pMiddleChihiIh);
        this.notMatchShapes.add(Letters.H.hHeadHunhur);
        this.notMatchShapes.add(Letters.H.hHeadHanhar);
        this.notMatchShapes.add(Letters.H.hMiddleHunhur);
        this.notMatchShapes.add(Letters.H.hMiddleDoubleAchvg);
        this.notMatchShapes.add(Letters.G.gHeadHanhar);
        this.notMatchShapes.add(Letters.G.gHeadHunhur);
        this.notMatchShapes.add(Letters.G.gMiddleHunhur);
        this.notMatchShapes.add(Letters.G.gMiddleDoubleAchvg);
        this.notMatchShapes.add(Letters.G.gMiddleDoubleNAchvg);
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
