package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.BoardDTO;
// <BoardDTO, primarykey 타입>
// Repository == DAO(Model)
public interface BoardRepository extends CrudRepository<BoardDTO, Integer>{

    BoardDTO findBySeq(Integer seq);
    
}
