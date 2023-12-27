package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.persistence.PagingBoardRepository;


@Controller
public class PagingBoardController {
    
    @Autowired
    PagingBoardRepository repo;

    @RequestMapping("pagingSample")
    public String pagingSample(Model m) {

        Pageable paging = PageRequest.of(0, 3);

        m.addAttribute("boardList", repo.findAll(paging));
        return "/board/getBoardList";
    }
    
}
