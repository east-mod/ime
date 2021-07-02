package com.zorigt.ime.filter;

import com.zorigt.ime.letter.ZCode;

import java.util.regex.Pattern;

public class BTailKeyFilter implements KeyFilter {

    @Override
    public String getKey() {
        return "b" + "-tail";
    }

    @Override
    public boolean accept(String str) {
        return !Pattern.matches("[^" + ZCode.b_banbvr_baga + ZCode.b_banbvr_ih +
                "]+[" + ZCode.b_banbvr_baga + ZCode.b_banbvr_ih + "]$", str);
    }
}
