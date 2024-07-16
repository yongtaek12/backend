package com.example.repository.mybatis;

import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import com.example.web.dtos.SearchDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
//    List<BoardDto> findAll(Map<String, Object> paramMap);
    List<BoardDto> findAll(@Param("offset") int offset, @Param("pageSize") int pageSize);

    Optional<BoardDto> findById(Long id);

    void updateBoard (@Param("idx") Long idx, @Param("updateParam") BoardUpdateDto boardUpdateDto);

    void insertBoard(BoardDto boardDto);

    void deleteBoard (Long id);

    int countBoards();
}
