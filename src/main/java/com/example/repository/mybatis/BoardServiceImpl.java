package com.example.repository.mybatis;

import com.example.model.PageInfo;
import com.example.services.BoardService;
import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import com.example.web.dtos.SearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public PageInfo<BoardDto> findAll(int pageIndex, int pageSize) {

        int count = boardMapper.countBoards();
        log.info("service Impl pageIndex ={}, pageSize={}",pageIndex, pageSize );
        List<BoardDto> boardDtos = boardMapper.findAll((pageIndex-1) * pageSize, pageSize);


        return  new PageInfo<>(pageIndex, pageSize,count,boardDtos);
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return boardMapper.findById(id);
    }

    @Override
    public void insert(BoardDto boardDto) {

        boardMapper.insertBoard(boardDto);
        log.info("로그 ", boardDto.getIdx());
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
