package com.book.mappers; 

import org.apache.ibatis.annotations.Mapper;
import com.book.Entity.BoardDTO; 
import java.util.List;

@Mapper
public interface BoardMapper {
    void save(BoardDTO boardDTO);      // 1단계
    List<BoardDTO> findAll();         // 2단계 
    BoardDTO findById(Long id);       // 3단계
}
