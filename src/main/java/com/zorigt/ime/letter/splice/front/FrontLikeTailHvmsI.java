package com.zorigt.ime.letter.splice.front;

import com.zorigt.ime.letter.LetterShapeSequence;
import com.zorigt.ime.letter.splice.FrontRuleHolder;
import com.zorigt.ime.letter.splice.SplicingAtFrontRule;

public class FrontLikeTailHvmsI implements SplicingAtFrontRule {
    @Override
    public boolean match(LetterShapeSequence lss) {
        if (lss.isEmpty()) {
            return false;
        }
        return !FrontRuleHolder.FRONT_LIKE_TAIL_SILBI_SUUL_1_I.match(lss);
    }
}
