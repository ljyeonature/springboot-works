package com.example.demo.domain;

import lombok.Data;

@Data
public class BoardVO {

    private int seq; // Integer
    private String title;
    private String writer;
    private String content;
    private String regdate;
    private int cnt;
    
    private long fileId;
    
}
