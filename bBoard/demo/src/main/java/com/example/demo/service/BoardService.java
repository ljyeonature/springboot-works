package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardVO;

public interface BoardService {
	List<BoardVO> getBoardList();
	// BoardVO getBoard(BoardVO vo);
}
