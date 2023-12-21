package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;

public interface BoardService {
    public List<BoardVO> getBoardList();
    public int saveBoard(BoardVO vo, FileVO fvo);
    public BoardVO getBoard(BoardVO vo);
    public int updateBoard(BoardVO vo);
    public int deleteBoard(BoardVO vo);
}
