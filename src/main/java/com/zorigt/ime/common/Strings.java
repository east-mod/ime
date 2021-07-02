package com.zorigt.ime.common;


public final class Strings {
    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public static boolean isNotBlank(String s) {
        return s != null && !s.trim().isEmpty();
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static String valueOf(char... chars) {
        if (chars == null) {
            return null;
        }
        if (chars.length == 1) {
            return String.valueOf(chars[0]);
        }
        StringBuilder s = new StringBuilder(chars.length);
        for (char c : chars) {
            s.append(c);
        }
        return s.toString();
    }
}
