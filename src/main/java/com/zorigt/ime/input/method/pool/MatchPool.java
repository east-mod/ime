package com.zorigt.ime.input.method.pool;

import com.zorigt.ime.approximate.matching.SuggestWord;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class MatchPool {
    private final ExecutorService executorService = Executors.newFixedThreadPool(7);

    public List<Future<List<SuggestWord>>> execute(List<Callable<List<SuggestWord>>> tasks) {
        try {
            return executorService.invokeAll(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("pool execute error.");
        }
    }
}
