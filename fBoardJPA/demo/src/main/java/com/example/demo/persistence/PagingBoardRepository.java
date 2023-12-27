package com.example.demo.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.BoardDTO;

public interface PagingBoardRepository extends CrudRepository<BoardDTO, Integer>{
    List<BoardDTO> findAll(Pageable p);
}
