package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.domain.BoardDTO;
import com.example.demo.persistence.QueryAnnoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class QueryAnnoController {
    
    @Autowired
    QueryAnnoRepository repo;

    @RequestMapping("queryAnno")
    public String queryAnno(Model m) {

        List<BoardDTO> result = repo.queryAnno("춘");
        m.addAttribute("boardList", result);
        return "board/getBoardList";
    }
    
}
