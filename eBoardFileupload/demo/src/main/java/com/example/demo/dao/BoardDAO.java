package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.BoardVO;

@Mapper
public interface BoardDAO {
	public List<BoardVO> getBoardList();
	// public BoardVO getBoard(BoardVO vo);

    public BoardVO getBoard(BoardVO vo);

	public int saveBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
    public int deleteBoard(BoardVO vo);	
}
