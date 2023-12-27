package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.BoardDTO;
import com.example.demo.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService{


    @Autowired
    BoardRepository boardRepo;

    BoardDTO board;

    // 전체검색
    @Override
    public List<BoardDTO> getBoardList() {

        List<BoardDTO> list = (List<BoardDTO>) boardRepo.findAll();
        return list;

    }

    // 글 상세보기
    @Override
    public BoardDTO getBoard(BoardDTO dto) {
        board.increaseViewCount();
        BoardDTO result = boardRepo.findById(dto.getSeq()).get();
        return result;

    }

    // 글 저장하기(DB)
    @Override
    public void saveBoard(BoardDTO dto) {
        boardRepo.save(dto);
    }

    /* Repository
     *      - findAll()
     *      - findById()
     *      - save()
     *      - deleteById
     */  
    

    // 글 수정하기
    @Override
    public void updateBoard(BoardDTO dto) {
        boardRepo.save(dto);
    }

    // 글 삭제하기
    @Override
    public void deleteBoard(BoardDTO dto) {

        boardRepo.deleteById(dto.getSeq());
       
    }


  
} 
