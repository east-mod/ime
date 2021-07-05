package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;
import java.util.Set;

public class FrontLikeTailSilbiSuul1I implements SplicingAtFrontRule {
    private final Set<LetterShape> matchShapes = new HashSet<>(16);

    private void init() {
        if (!matchShapes.isEmpty()) {
            return;
        }
        matchShapes.add(Letters.B.bHeadBanbvrBaga);
        matchShapes.add(Letters.B.bMiddleBanbvrBaga);
        matchShapes.add(Letters.P.pHeadChihiBaga);
        matchShapes.add(Letters.P.pMiddleChihiBaga);
        matchShapes.add(Letters.H.hHeadHinhir);
        matchShapes.add(Letters.H.hMiddleHinhir);
        matchShapes.add(Letters.G.gHeadHinhir);
        matchShapes.add(Letters.G.gMiddleHinhir);
        matchShapes.add(Letters.F.fHeadChihiBaga);
        matchShapes.add(Letters.F.fMiddleChihiBaga);
        matchShapes.add(Letters.K.kHeadBaga);
        matchShapes.add(Letters.K.kMiddleBaga);
    }

    @Override
    public boolean match(LetterShapeSequence lss) {
        init();
        if (lss.isEmpty()) {
            return false;
        }
        LetterShape last = lss.getLast();
        if (last == null) {
            return false;
        }
        return matchShapes.contains(last);
    }
}
