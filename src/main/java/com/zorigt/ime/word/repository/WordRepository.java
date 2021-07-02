package com.zorigt.ime.word.repository;

import com.zorigt.ime.word.model.WordEntity;
import com.zorigt.ime.word.repository.mapper.WordMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class WordRepository {
    @Resource
    private WordMapper wordMapper;

    public List<WordEntity> queryAll(final int length, final int gtFrequency, final int pageNum, final int pageSize) {
        return wordMapper.queryAllByLengthAndGtFrequency(
                length, gtFrequency, (pageNum - 1) * pageSize, pageSize);
    }

    public int queryMaxLength(final int gtFrequency) {
        return wordMapper.queryMaxLengthByFrequency(gtFrequency);
    }
}
