package com.zorigt.ime.approximate.matching;

public class DefaultMount implements MountObject {
    private final String str;

    public DefaultMount(String str) {
        this.str = str;
    }

    @Override
    public String getString() {
        return this.str;
    }
}
