package com.zorigt.ime.common;

import java.util.function.BiFunction;

public class BatchExecutor {
    public static void queryAll(BiFunction<Integer, Integer, Integer> biFunction) {
        int pageNum = 1;
        int pageSize = 1000;
        int size = 0;
        while (pageNum == 1 || size == pageSize) {
            size = biFunction.apply(pageNum, pageSize);
            pageNum++;
        }
    }
}
