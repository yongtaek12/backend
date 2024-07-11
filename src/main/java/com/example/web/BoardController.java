package com.example.web;

import com.example.services.BoardService;
import com.example.web.dtos.BoardDto;
import com.example.web.dtos.BoardUpdateDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board/list")
    public List<BoardDto> boardList(Model model) {
        System.out.println("-----------------------------------");
        System.out.println("dddd" +boardService.findAll() );
        return boardService.findAll();


    }

    @GetMapping("/board/{id}")
    public Optional<BoardDto> getBoard(@PathVariable String id) {
        return boardService.findById(Long.parseLong(id));
    }

    @PostMapping("/board")
    public void insert(@RequestBody BoardDto boardDto) {
         boardService.insert(boardDto);
    }

    @PatchMapping("/board")
    public void update(@RequestBody BoardDto boardDto) {
         long idx = boardDto.getIdx();
         BoardUpdateDto boardUpdateDto = BoardUpdateDto.builder()
                        .author(boardDto.getAuthor())
                        .title(boardDto.getTitle())
                        .contents(boardDto.getContents())
                        .createdAt(boardDto.getCreatedAt()).build();
             boardService.update(idx, boardUpdateDto);
    }

    @DeleteMapping("/board/{id}")
    public void delete(@PathVariable Long idx) {
        boardService.delete(idx);
    }
    //API 연결테스트..
    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getApiTest(){

        return "{\"result\" : \"ok\"}";
    }



}