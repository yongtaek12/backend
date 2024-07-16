package com.example.web;

import com.example.model.PageInfo;
import com.example.services.BoardService;
import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/list")
    public Page<BoardDto> boardList(@RequestParam(value = "pageIndex", defaultValue = "1") int pageIndex, @RequestParam(value = "pageSize",defaultValue = "10") int pageSize, Pageable page){

        log.info("pageIndex ={}, pageSize={}",pageIndex, pageSize );
        return boardService.findAll(pageIndex,pageIndex,page);
    }

    @GetMapping("/board/{idx}")
    public Optional<BoardDto> getBoard(@PathVariable(value = "idx") String idx) {
        return boardService.findById(Long.parseLong(idx));
    }

    @PostMapping("/board")
    public BoardDto insert(@RequestBody BoardDto boardDto) {
         boardService.insert(boardDto);

         log.info("controller {}", boardDto);
         return boardDto;
    }

    @PatchMapping("/board")
    public BoardDto update(@RequestBody BoardDto boardDto) {
         long idx = boardDto.getIdx();
         BoardUpdateDto boardUpdateDto = BoardUpdateDto.builder()
                        .author(boardDto.getAuthor())
                        .title(boardDto.getTitle())
                        .contents(boardDto.getContents())
                        .createdAt(boardDto.getCreatedAt()).build();
             boardService.update(idx, boardUpdateDto);
             return boardDto;
    }

    @DeleteMapping("/board/{idx}")
    public void delete(@PathVariable(value = "idx") Long idx) {
        boardService.delete(idx);
    }
    //API 연결테스트..
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getApiTest(){

        return "{\"result\" : \"ok\"}";
    }



}