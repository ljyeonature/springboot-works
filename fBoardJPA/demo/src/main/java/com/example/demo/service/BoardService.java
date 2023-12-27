package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardDTO;

public interface BoardService {
    List<BoardDTO> getBoardList();

    BoardDTO getBoard(BoardDTO dto);
    public void saveBoard(BoardDTO dto);
    public void updateBoard(BoardDTO dto);
    public void deleteBoard(BoardDTO dto);

}
