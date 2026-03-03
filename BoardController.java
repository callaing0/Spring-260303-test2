package com.book.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.book.service.BoardService;

import com.book.Entity.BoardDTO;

import org.springframework.ui.Model;

@Controller
public class BoardController {
	@Autowired
    private BoardService boardService;

    // 1단계: 등록 화면 이동
    @GetMapping("/Thymeleaf/register")
    public String registerForm() {
        return "Thymeleaf/register";
    }

    // 1단계: DB 저장 (요구사항에 따라 GET 방식 사용)
    @GetMapping("/Thymeleaf/save")
    public String save(BoardDTO boardDTO, Model model) {
        boardService.save(boardDTO);
        model.addAttribute("msg", "등록 완료 되었습니다.");
        return "Thymeleaf/result"; 
    }

    // 2단계: 목록 조회
    @GetMapping("/Thymeleaf/list")
    public String list(Model model) {
        List<BoardDTO> list = boardService.findAll();
        model.addAttribute("list", list);
        return "Thymeleaf/list";
    }

    // 3단계: 상세 보기
    @GetMapping("/Thymeleaf/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        BoardDTO board = boardService.findById(id);
        if (board == null) {
            model.addAttribute("msg", "존재하지 않는 게시글입니다.");
            return "errorPage"; 
        }
        model.addAttribute("board", board);
        return "Thymeleaf/detail";
    }

}
