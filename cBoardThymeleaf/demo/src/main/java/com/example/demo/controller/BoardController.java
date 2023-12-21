package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;


@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // [ 요청 ] http://127.0.0.1:8080/board/xxxxxxxx
    @RequestMapping("/{step}")
    public String viewPage(@PathVariable String step){
        return "/board/"+ step;
        // WEB-INF/views/ + board + xxxxxxxx + .jsp
    }

    // 글목록검색
    // [ 요청 ] http://127.0.0.1:8080/board/getBoardList
    @RequestMapping("getBoardList")
    public void getBoardList(Model m) {
        List<BoardVO> list = boardService.getBoardList();
        System.out.println("확인1");
        m.addAttribute("boardList", list);
        // WEB-INF/views/ + board/getBoardList + .jsp
    }

    // 글 상세 보기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("getBoard")
    public void getBoard(BoardVO vo, Model m) {
        BoardVO board = boardService.getBoard(vo);
        System.out.println("확인2");
        m.addAttribute("board", board);
        // WEB-INF/views/ + board/getBoardList + .jsp
    }

     // 글 저장하기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("saveBoard")
    public String saveBoard(BoardVO vo) {
        int result = boardService.saveBoard(vo);
        System.out.println("확인2 : " + result);
        // return "getBoradList";
        return "redirect:getBoardList";
        // WEB-INF/views/ + board/getBoardList + .jsp
    }


     // 글 수정하기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("updateBoard")
    public String updateBoard(BoardVO vo) {
        int result = boardService.updateBoard(vo);
        System.out.println("확인2 : " + result);
        // return "getBoradList";
        return "redirect:getBoardList";
        // WEB-INF/views/ + board/getBoardList + .jsp
    }

    // 글 삭제하기
    // [ 요청 ] http://127.0.0.1:8080/board/getBoard
    @RequestMapping("deleteBoard")
    public String deleteBoard(BoardVO vo) {
        int result = boardService.deleteBoard(vo);
        System.out.println("확인2 : " + result);
        // return "getBoradList";
        return "redirect:getBoardList";
        // WEB-INF/views/ + board/getBoardList + .jsp
    }
}
