package com.zorigt.ime.letter.splice.behind;

import com.zorigt.ime.letter.LetterShape;
import com.zorigt.ime.letter.splice.BehindRuleHolder;
import com.zorigt.ime.letter.splice.SplicingAtBehindRule;

public class BehindIsNotEhshig implements SplicingAtBehindRule {
    @Override
    public boolean match(LetterShape ls) {
        if (ls == null) {
            return false;
        }
        return !BehindRuleHolder.BEHIND_IS_EHSHIG.match(ls);
    }
}
