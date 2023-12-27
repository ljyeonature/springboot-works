package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.BoardDTO;

public interface QueryAnnoRepository extends CrudRepository<BoardDTO, Integer>{
    
    //*******************************************    
    
    // [1] 복잡한 쿼리 - JPQL (*** SQL 문장 아님)
    //      테이블명이 아니고, BoardDTO 클래스명
    // @Query("SELECT b FROM BoardDTO b WHERE b.title like %?1% ORDER BY b.seq DESC")
    // List<BoardDTO> queryAnno(String word);
    
    //*******************************************

    // [2] 복잡한 쿼리 - SQL 문장
    @Query(value="SELECT * FROM boarddto WHERE title like %?1% ORDER BY seq DESC", nativeQuery = true)
    List<BoardDTO> queryAnno(String word);


}
