package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.MemberVO;

@Mapper
public interface MemberDAO {
    public int insertMember(MemberVO dto);

    public MemberVO login(MemberVO vo);
} 
