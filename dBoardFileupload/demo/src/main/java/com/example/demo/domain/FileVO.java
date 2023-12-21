package com.example.demo.domain;

import lombok.Data;

@Data
public class FileVO {
    Long fileId;
    String originFilename;
    String filename;
    String filepath;
}
