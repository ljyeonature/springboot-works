package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SignupDAO;
import com.example.demo.domain.SignupDTO;


@Service
public class SignupServiceImpl implements SignupService {

    @Autowired
    private SignupDAO SignupDAO;

    @Override
    public int insertMember(SignupDTO dto) {
        int result = SignupDAO.insertMember(dto);
        System.out.println("Service Impl");
        return result;
    }

    
    
}
