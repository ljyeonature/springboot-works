package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.BoardVO;
import com.example.demo.service.BoardService;


@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 글목록검색
    @RequestMapping("getBoardList")
    public void getBoardList(Model m) {
        List<BoardVO> list = boardService.getBoardList();
        System.out.println("확인1");
        m.addAttribute("boardList", list);

    }

}
