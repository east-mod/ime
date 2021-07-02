package com.zorigt.ime.filter;

public interface KeyFilter {
    String getKey();

    boolean accept(String str);
}
