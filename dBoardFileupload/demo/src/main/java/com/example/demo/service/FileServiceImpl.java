package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FileDAO;
import com.example.demo.domain.FileVO;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    FileDAO fileDAO;

    @Override
    public void insertFile(FileVO vo) {
        fileDAO.insertFile(vo);
    }

    @Override
    public FileVO selectFile(FileVO vo) {
        return fileDAO.selectFile(vo);
    }

    @Override
    public Long selectId() {
        return fileDAO.selectId();
    }
    
}
