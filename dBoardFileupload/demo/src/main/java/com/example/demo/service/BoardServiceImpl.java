package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.BoardDAO;
import com.example.demo.dao.FileDAO;
import com.example.demo.domain.BoardVO;
import com.example.demo.domain.FileVO;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private FileDAO fileDAO;

    @Override
    public List<BoardVO> getBoardList() {

        // return boardDAO.getBoardList();
        List<BoardVO> list = boardDAO.getBoardList();
        System.out.println("확인: " + list.size());
        return list;
    }

    @Override
    @Transactional
    public int saveBoard(BoardVO bvo, FileVO fvo) {
        if(fvo != null) {
            // 파일 첨부가 있는 경우
            fileDAO.insertFile(fvo);
            bvo.setFileId( fileDAO.selectId() );
        }
        int result = boardDAO.saveBoard(bvo);
        return result;
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        BoardVO board = boardDAO.getBoard(vo);
        return board;

    }

    @Override
    public int updateBoard(BoardVO vo) {

        int result = boardDAO.updateBoard(vo);
        return result;
    }

    @Override
    public int deleteBoard(BoardVO vo) {
        int result = boardDAO.deleteBoard(vo);
        return result;
    }
} 
