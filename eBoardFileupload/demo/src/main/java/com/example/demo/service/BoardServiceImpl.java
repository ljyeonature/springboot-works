package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BoardDAO;
import com.example.demo.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardVO> getBoardList() {

        // return boardDAO.getBoardList();

        List<BoardVO> list = boardDAO.getBoardList();
        System.out.println("확인: " + list.size());
        return list;
    }

    @Override
    public BoardVO getBoard(BoardVO vo) {
        return boardDAO.getBoard(vo);
    }
    @Override
    public int saveBoard(BoardVO vo) {

        return boardDAO.saveBoard(vo);
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
