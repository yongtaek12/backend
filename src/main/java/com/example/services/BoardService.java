package com.example.services;


import com.example.model.PageInfo;
import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import com.example.web.dtos.SearchDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BoardService {

    PageInfo<BoardDto> findAll(int offset, int limit);

    Optional<BoardDto> findById(Long id);

    void insert(BoardDto boardDto);

    void update (Long idx, BoardUpdateDto boardUpdateDto);

    void delete (Long id);


//    Pageable<Map<String, Object>> findAllPaging (Map<String, Object> paramMap, Pageable page);
}
