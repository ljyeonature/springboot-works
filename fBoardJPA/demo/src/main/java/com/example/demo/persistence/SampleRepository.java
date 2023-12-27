package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.BoardDTO;
import java.util.List;


public interface SampleRepository extends CrudRepository<BoardDTO, Integer>{

    List<BoardDTO> findByTitle(String title);               // -> where title = ?findByWriter
    List<BoardDTO> findByWriter(String writer);             // -> where title = ?findByWriter
    List<BoardDTO> findByCnt(Integer cnt);                  // -> where title = ?findByWriter
    List<BoardDTO> findByCntIsNull();
    List<BoardDTO> findByWriterContaining(String string);
    List<BoardDTO> findByTitleOrWriter(String string, String string2);
    
}
