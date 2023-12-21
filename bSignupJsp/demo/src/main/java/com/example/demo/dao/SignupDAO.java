package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.SignupDTO;

@Mapper
public interface SignupDAO {
    public int insertMember(SignupDTO dto);
} 
