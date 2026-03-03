package com.book.service;

import java.util.List;

import com.book.Entity.BoardDTO;

public interface BoardService {
	void save(BoardDTO boardDTO);      // 1단계: 저장
    List<BoardDTO> findAll();         // 2단계: 목록 조회
    BoardDTO findById(Long id);       // 3단계: 상세 보기

}
