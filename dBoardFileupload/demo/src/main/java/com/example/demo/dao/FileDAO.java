package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.FileVO;

@Mapper
public interface FileDAO {
    
    // 입력
    public void insertFile(FileVO vo);
    // 검색 - 검색 조건(key값으로)
    public FileVO selectFile(FileVO vo);
    // id 값 가져오기 : 자동 증가수 가장 큰 수 얻기 위해.?
    public Long selectId();

}
