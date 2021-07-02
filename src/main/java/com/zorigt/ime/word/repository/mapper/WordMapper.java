package com.zorigt.ime.word.repository.mapper;

import com.zorigt.ime.word.model.WordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WordMapper {
    List<WordEntity> queryAllByLengthAndGtFrequency(@Param("length") int length, @Param("gtFrequency") int gtFrequency,
                                                    @Param("offset") int offset, @Param("size") int size);

    int queryMaxLengthByFrequency(@Param("gtFrequency") int gtFrequency);
}
