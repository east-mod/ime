package com.zorigt.ime.black.sequence.repository;

import com.zorigt.ime.black.sequence.model.BlackSequence;
import com.zorigt.ime.black.sequence.repository.mapper.BlackSequenceMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Component
public class BlackSequenceRepository {
    @Resource
    private BlackSequenceMapper blackSequenceMapper;

    public List<BlackSequence> queryAll(int pageNum, int pageSize) {
        return blackSequenceMapper.queryAll((pageNum - 1) * pageSize, pageSize);
    }

    public void insertAll(Collection<String> collection) {
        blackSequenceMapper.insertAll(collection);
    }
}
