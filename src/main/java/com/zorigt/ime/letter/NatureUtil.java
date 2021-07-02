package com.zorigt.ime.letter;

import com.zorigt.ime.common.Strings;

public class NatureUtil {
    public static Nature getNature(String latinKey) {
        if (Strings.isBlank(latinKey)) {
            return Nature.SAARMAG;
        }
        if (latinKey.equals(Letters.A.latinKey) || latinKey.equals(Letters.O.latinKey)) {
            return Nature.CHAGH;
        } else if (latinKey.equals(Letters.E.latinKey) || latinKey.equals(Letters.U.latinKey)) {
            return Nature.HUNDII;
        } else {
            return Nature.SAARMAG;
        }
    }
}
