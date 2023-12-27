package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


/**
 *   @Controller - 뷰 페이지 지정해야 함
 *                  (jsp / thymeleaf(html)로 응답을 주는 경우 )
 * 
 *                  (*) ajax 인 경우
 *                      @Controller + @ResponseBody
 *   @RestController == @Controller + @ResponseBody
 *   
 */



@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name="BoardController", description="이 클래스에 대한 설명부분")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/hello")
    public String hello() {
        return "REST 컨트롤러";
    }

    @GetMapping("/board")
    public List<BoardVO> getBoardList(Model m) {
        // BoardVO vo = new BoardVO();
        List<BoardVO> list = boardService.getBoardList();
        m.addAttribute("boardList", list);
        return list;
    }

    @GetMapping("/board/{seq}")
    public BoardVO getBoard(@PathVariable Integer seq) {
        BoardVO vo = new BoardVO();
        vo.setSeq(seq);
        BoardVO result = boardService.getBoard(vo);
        return result;
    }

    @PostMapping("/board/write")
    public void saveBoard(BoardVO vo) {
        System.out.println("/board/write post 요청");
        boardService.saveBoard(vo);
    }

    @PutMapping("/board/update/{seq}")
    public void updateBoard(@PathVariable Integer seq) {
        BoardVO vo = new BoardVO();
        vo.setSeq(seq);
        System.out.println("/board/update put 요청");
        boardService.updateBoard(vo);
    }

    @DeleteMapping("/board/{seq}")
    public void deleteBoard(@PathVariable Integer seq) {
        BoardVO vo = new BoardVO();
        vo.setSeq(seq);
        System.out.println("/board/{seq} delete 요청");
        boardService.deleteBoard(vo);
    }
    

    

}
