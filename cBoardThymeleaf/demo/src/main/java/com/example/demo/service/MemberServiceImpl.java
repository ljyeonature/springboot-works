package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.domain.MemberVO;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO SignupDAO;

    @Override
    public int insertMember(MemberVO dto) {
        int result = SignupDAO.insertMember(dto);
        System.out.println("Service Impl");
        return result;
    }

    @Override
    public MemberVO login(MemberVO vo) {
        MemberVO result = SignupDAO.login(vo);
        System.out.println("login DAO");
        return result;
    }

    
    
}
