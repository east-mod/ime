package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterLocation;
import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontTailGedesSuul1U implements SplicingAtFrontRule {
    private final Set<LetterShape> notMatchShapes;

    public FrontTailGedesSuul1U() {
        this.notMatchShapes = new HashSet<>(16);
    }

    private synchronized void init() {
        if (!this.notMatchShapes.isEmpty()) {
            return;
        }
        this.notMatchShapes.add(Letters.H.hHeadHinhir);
        this.notMatchShapes.add(Letters.H.hHeadHanhar);
        this.notMatchShapes.add(Letters.G.gHeadHinhir);
        this.notMatchShapes.add(Letters.G.gHeadHanhar);
    }

    @Override
    public boolean match(LetterShapeSequence lss) {
        this.init();
        if (lss.isEmpty()) {
            return false;
        }
        LetterShape last = lss.getLast();
        if (last == null || last.getLocation() != LetterLocation.HEAD) {
            return false;
        }
        return !this.notMatchShapes.contains(last);
    }
}
