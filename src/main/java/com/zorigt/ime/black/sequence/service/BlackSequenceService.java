package com.zorigt.ime.black.sequence.service;

import com.zorigt.ime.black.sequence.model.BlackSequence;
import com.zorigt.ime.black.sequence.repository.BlackSequenceRepository;
import com.zorigt.ime.common.BatchExecutor;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BlackSequenceService implements ApplicationRunner {
    private final Logger logger = LoggerFactory.getLogger(BlackSequenceService.class);

    @Resource
    private BlackSequenceRepository blackSequenceRepository;

    private final Set<String> blackSet = Collections.synchronizedSet(new HashSet<>(1024 * 128));

    private final Set<String> newBlackSet = Collections.synchronizedSet(new HashSet<>(1024));

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BatchExecutor.queryAll((pageNum, pageSize) -> {
            List<BlackSequence> blackSequenceList = blackSequenceRepository.queryAll(pageNum, pageSize);
            if (CollectionUtils.isEmpty(blackSequenceList)) {
                return 0;
            }
            for (BlackSequence blackSequence : blackSequenceList) {
                blackSet.add(blackSequence.getStr());
            }
            return blackSequenceList.size();
        });
    }

    public boolean contains(String src) {
        return blackSet.contains(src) || newBlackSet.contains(src);
    }

    public void add(String src) {
        newBlackSet.add(src);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5 * 1000)
    public void syn() {
        logger.info("BlackSequenceService.syn start...");
        if (newBlackSet.size() > 0) {
            logger.info("syn black sequence size:{}", newBlackSet.size());
            blackSequenceRepository.insertAll(newBlackSet);
            blackSet.addAll(newBlackSet);
            newBlackSet.clear();
        }
        logger.info("BlackSequenceService.syn end");
    }
}
