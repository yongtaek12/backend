package com.example.repository.mybatis;

import com.example.model.PageInfo;
import com.example.services.BoardService;
import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import com.example.web.dtos.SearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<BoardDto> findAll(int offset, int pageSize, Pageable page) {

        int count = boardMapper.countBoards();
        offset = (int) page.getOffset();
        pageSize = page.getPageSize();
        log.info("service Impl pageIndex ={}, pageSize={}",offset, pageSize );
        List<BoardDto> boardDtos = boardMapper.findAll(offset, pageSize);
        int cnt = boardMapper.countBoards();


        return new PageImpl<>(boardDtos,page,cnt);
//        return  new PageInfo<>(pageIndex, pageSize,count,boardDtos);
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

    @Override
    public int countBoards() {
        return boardMapper.countBoards();
    }
}
