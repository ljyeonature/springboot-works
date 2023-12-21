package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.BoardVO;

@Mapper
public interface BoardDAO {
	public List<BoardVO> getBoardList();
	// public BoardVO getBoard(BoardVO vo);
}
