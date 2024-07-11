package com.example.repository.mybatis;

import com.example.services.BoardService;
import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDto> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return boardMapper.findById(id);
    }

    @Override
    public void insert(BoardDto boardDto) {
        boardMapper.insertBoard(boardDto);
    }

    @Override
    public void update(Long idx, BoardUpdateDto boardUpdateDto) {
        boardMapper.updateBoard(idx, boardUpdateDto);
    }

    @Override
    public void delete(Long idx) {
        boardMapper.deleteBoard(idx);
    }
}
