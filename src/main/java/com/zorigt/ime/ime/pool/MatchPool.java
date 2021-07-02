package com.zorigt.ime.ime.pool;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MatchPool {
    private final ExecutorService executorService = Executors.newFixedThreadPool(7);

    public void execute(List<Callable<Void>> tasks) {
        try {
            executorService.invokeAll(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("pool execute error.");
        }
    }
}
