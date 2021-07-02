package com.zorigt.ime.common;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class BatchExecutor {
    private static final transient Logger logger = LoggerFactory.getLogger(BatchExecutor.class);

    public static void queryAll(BiFunction<Integer, Integer, Integer> biFunction) {
        int pageNum = 1;
        int pageSize = 1000;
        int size = 0;
        while (pageNum == 1 || size == pageSize) {
            size = biFunction.apply(pageNum, pageSize);
            pageNum++;
        }
    }

    public static <T> void saveAll(Collection<T> collection, Consumer<List<T>> consumer) {
        int pageSize = 10000;
        int pageNum = 1;
        List<T> subList = Lists.newArrayListWithExpectedSize(pageSize);
        for (T t : collection) {
            if (CollectionUtils.isNotEmpty(subList) && subList.size() % pageSize == 0) {
                consumer.accept(subList);
                logger.info("page num:{}", pageNum);
                pageNum++;
                subList = Lists.newArrayListWithExpectedSize(pageSize);
            }
            subList.add(t);
        }
        if (CollectionUtils.isNotEmpty(subList)) {
            consumer.accept(subList);
            logger.info("page num:{}", pageNum);
        }
    }
}
