package com.example.demo;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BoardVO;

// @Controller -> 뷰 페이지 필요
@RestController
public class SampleController {
    
    @RequestMapping("/hello")
    public String hello() {
        return "안녕 부트";
    }

    @RequestMapping("/hello2")
    public BoardVO hello2() {
        BoardVO vo = new BoardVO();
        vo.setSeq(1000);
        vo.setTitle("테스트");
        vo.setWriter("홍길동");
        return vo;
    }

    @RequestMapping("/hello3")
    public List<BoardVO> hello3() {
        List<BoardVO> list  = new ArrayList<BoardVO>();
        for(int i=0; i<3; i++) {
            BoardVO vo = new BoardVO();
            vo.setSeq(i);
            vo.setTitle("제목" + i);
            vo.setContent("내용"+i);
            list.add(vo);
        }
        return list;
    }
    
    
}
