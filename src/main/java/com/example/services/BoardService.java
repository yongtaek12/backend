package com.example.services;


import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    List<BoardDto> findAll();

    Optional<BoardDto> findById(Long id);

    void insert(BoardDto boardDto);

    void update (Long idx, BoardUpdateDto boardUpdateDto);

    void delete (Long id);
}
