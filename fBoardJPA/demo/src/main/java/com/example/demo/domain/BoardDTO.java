package com.example.demo.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data       //lombok
@Entity     // JPA가 되는 객체(VO != DTO != Entity) -> DTO가 Entity역할 하도록
// @Table(name = "board")
public class BoardDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;        // 글 번호

    private String  title;      // 글 제목
    private String  writer;     // 글 작성자
    private String  content;    // 글 내용

    @Column(columnDefinition = "date default sysdate()", nullable = true)
    private Date    regdate;    // 작성 날짜

    // @Column(columnDefinition = "date default 0")
    private Integer cnt;        // 조회수

    public BoardDTO() {
        this.cnt = 0;
        this.regdate = new Date();
    }

    public void increaseViewCount() {
        this.cnt++;
    }
}
