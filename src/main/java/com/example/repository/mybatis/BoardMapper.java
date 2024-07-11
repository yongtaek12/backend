package com.example.repository.mybatis;

import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    List<BoardDto> findAll();

    Optional<BoardDto> findById(Long id);

    void updateBoard (@Param("idx") Long idx, @Param("updateParam") BoardUpdateDto boardUpdateDto);

    void insertBoard(BoardDto boardDto);

    void deleteBoard (Long id);
}
