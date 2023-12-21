package com.example.demo.service;

import com.example.demo.domain.FileVO;
import com.example.demo.domain.MemberVO;

public interface MemberService {

    public int insertMember(MemberVO dto, FileVO fvo);

    public MemberVO login(MemberVO vo);

    public String selectSrc(String name);
}
