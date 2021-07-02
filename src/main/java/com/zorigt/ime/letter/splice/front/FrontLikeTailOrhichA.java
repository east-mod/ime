package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.Letters;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

import java.util.HashSet;

public class FrontLikeTailOrhichA implements SplicingAtFrontRule {
    private final HashSet<LetterShape> matchShapes;

    public FrontLikeTailOrhichA() {
        this.matchShapes = new HashSet<>(64);
    }

    public synchronized void init() {
        if (!this.matchShapes.isEmpty()) {
            return;
        }
        this.matchShapes.add(Letters.A.aHead);
        this.matchShapes.add(Letters.A.aMiddle);
        this.matchShapes.add(Letters.I.iHead);
        this.matchShapes.add(Letters.I.iMiddle);
        this.matchShapes.add(Letters.O.oHeadTitemGedes);
        this.matchShapes.add(Letters.O.oMiddleGedes);
        this.matchShapes.add(Letters.N.nHead);
        this.matchShapes.add(Letters.N.nMiddleNAchvg);
        this.matchShapes.add(Letters.H.hHeadHanhar);
        this.matchShapes.add(Letters.G.gHeadHanhar);
        this.matchShapes.add(Letters.M.mHead);
        this.matchShapes.add(Letters.M.mMiddleAchvg);
        this.matchShapes.add(Letters.L.lHead);
        this.matchShapes.add(Letters.L.lMiddleAchvg);
        this.matchShapes.add(Letters.S.sHead);
        this.matchShapes.add(Letters.S.sMiddle);
        this.matchShapes.add(Letters.X.xHead);
        this.matchShapes.add(Letters.X.xMidddle);
        this.matchShapes.add(Letters.T.tHead);
        this.matchShapes.add(Letters.T.tMiddleDSenj);
        this.matchShapes.add(Letters.D.dHeadDSenj);
        this.matchShapes.add(Letters.D.dMiddleDSenj);
        this.matchShapes.add(Letters.Q.qHead);
        this.matchShapes.add(Letters.Q.qMiddle);
        this.matchShapes.add(Letters.J.jHead);
        this.matchShapes.add(Letters.J.jMiddle);
        this.matchShapes.add(Letters.Y.yHead);
        this.matchShapes.add(Letters.Y.yMiddleErtegerSilbi);
        this.matchShapes.add(Letters.R.rHead);
        this.matchShapes.add(Letters.R.rMiddleErbgeljinSilbi);
        this.matchShapes.add(Letters.W.wHead);
        this.matchShapes.add(Letters.W.wMiddle);
        this.matchShapes.add(Letters.C.cHead);
        this.matchShapes.add(Letters.C.cMiddle);
        this.matchShapes.add(Letters.Z.zHead);
        this.matchShapes.add(Letters.Z.zMiddle);
        this.matchShapes.add(Letters.GALIG_H.galigHHead);
        this.matchShapes.add(Letters.GALIG_H.galigHMiddle);
        this.matchShapes.add(Letters.GALIG_R.galigRHead);
        this.matchShapes.add(Letters.GALIG_L.galigLHead);
        this.matchShapes.add(Letters.GALIG_ZH.galigZhHead);
        this.matchShapes.add(Letters.GALIG_CH.galigChHead);
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
