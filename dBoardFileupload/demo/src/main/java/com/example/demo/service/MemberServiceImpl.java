package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.FileDAO;
import com.example.demo.dao.MemberDAO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.MemberVO;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO SignupDAO;

    @Autowired
    private FileDAO fileDAO;


    @Override
    @Transactional
    public int insertMember(MemberVO dto, FileVO fvo) {
        if(fvo != null) {
            // 파일 첨부가 있는 경우
            fileDAO.insertFile(fvo);
            dto.setFileId( fileDAO.selectId() );
        }
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

    @Override
    public String selectSrc(String name) {
        String result = SignupDAO.selectSrc(name);
        return result;
    }

    
    
}
