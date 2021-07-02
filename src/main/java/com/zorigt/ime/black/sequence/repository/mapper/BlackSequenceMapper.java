package com.zorigt.ime.black.sequence.repository.mapper;

import com.zorigt.ime.black.sequence.model.BlackSequence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface BlackSequenceMapper {
    List<BlackSequence> queryAll(@Param("offset") int offset, @Param("size") int size);

    void insertAll(@Param("collection") Collection<String> collection);
}
