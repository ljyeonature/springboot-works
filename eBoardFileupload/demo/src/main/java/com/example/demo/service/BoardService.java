package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardVO;

public interface BoardService {
    List<BoardVO> getBoardList();

    BoardVO getBoard(BoardVO vo);
    public int saveBoard(BoardVO vo);
    public int updateBoard(BoardVO vo);
    public int deleteBoard(BoardVO vo);

}
