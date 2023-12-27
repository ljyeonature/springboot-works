package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.persistence.SampleRepository;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SampleController {

    // 원래는 서비스단을 주입하지만 레포지토리 바로 주입함

    @Autowired
    private SampleRepository repo;

    @RequestMapping("/sample")
    public String sample(Model m) {
        // 제목이 춘식이에게 레코드 검색
        // m.addAttribute("boardList", repo.findByTitle("춘식이에게"));  
        
        // 작성자가 홍길동인 레코드 검색
        // m.addAttribute("boardList", repo.findByWriter("지연누낭"));

        // cnt가 null인 레코드 검색
        // m.addAttribute("boardList", repo.findByCntIsNull());

        // cnt가 0인 레코드 검색
        // m.addAttribute("boardList", repo.findByCnt(0));

        // 제목이 춘식이에게이러나 작성자가 지연누낭인 레코드 검색
        // m.addAttribute("boardList", repo.findByTitleOrWriter("춘식이에게","지연누낭"));

        // 작성자 중에 '지' 이라는 단어가 있는 경우 검색
        m.addAttribute("boardList", repo.findByWriterContaining("지"));
        return "/board/getBoardList";
    }
    


}
