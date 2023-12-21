package com.example.demo.service;

import com.example.demo.domain.MemberVO;

public interface MemberService {

    public int insertMember(MemberVO dto);

    public MemberVO login(MemberVO vo);
}
