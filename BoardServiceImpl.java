package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.Entity.BoardDTO; 
import com.book.mappers.BoardMapper; 
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public void save(BoardDTO boardDTO) {
        boardMapper.save(boardDTO);
    }

    @Override
    public List<BoardDTO> findAll() {
        // 2단계 요구사항: 최신글이 위에 오도록 정렬 로직이 SQL에 포함되어야 함
        return boardMapper.findAll();
    }

    @Override
    public BoardDTO findById(Long id) {
        return boardMapper.findById(id);
    }
}
