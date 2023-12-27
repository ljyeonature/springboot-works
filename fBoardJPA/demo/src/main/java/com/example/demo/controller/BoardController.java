package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BoardDTO;
import com.example.demo.service.BoardService;


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

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/hello")
    public String hello() {
        return "REST 컨트롤러";
    }

    // [ 요청 ] http://127.0.0.1:8080/board/xxxxxxxx
    @RequestMapping("/{step}")
    public String viewPage(@PathVariable String step){
        return "/board/"+ step;
        // WEB-INF/views/ + board + xxxxxxxx + .jsp
    }

    // 게시판 전체 목록
    @RequestMapping("/getBoardList")
    public List<BoardDTO> getBoardList(Model m) {
        // BoardDTO vo = new BoardDTO();
        List<BoardDTO> list = boardService.getBoardList();
        m.addAttribute("boardList", list);
        return list;
    }

    // 게시글 상세보기
    @RequestMapping("/getBoard")
    public BoardDTO getBoard(BoardDTO dto, Model m) {
        System.out.println(dto.getCnt());
        BoardDTO result = boardService.getBoard(dto);
        m.addAttribute("board", result);
        return result;
    }

    // 게시글 저장하기
    @RequestMapping("/saveBoard")
    public String saveBoard(BoardDTO vo) {
        System.out.println("/write post 요청");
        boardService.saveBoard(vo);
        return "redirect:/board/getBoardList";

    }
    // 게시글 수정
    @RequestMapping("/updateBoard")
    public void updateBoard(BoardDTO dto) {
        System.out.println("update put 요청");
        boardService.updateBoard(dto);
    }

    // 게시글 삭제
    @RequestMapping("/deleteBoard")
    public String deleteBoard(BoardDTO dto) {
        System.out.println("delete 요청");
        boardService.deleteBoard(dto);
        return "redirect:getBoardList";
    }

}
