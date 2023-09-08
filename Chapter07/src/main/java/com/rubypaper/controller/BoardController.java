package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 글 등록 화면으로 이동
	@GetMapping("/insertBoardView")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	// 글 등록 처리
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		// 리턴되는 View이름 앞에 "forward:"이나 "redirect:"을 붙이면 ViewResovler가 동작하지 않는다.
		return "redirect:getBoardList";
	}
	
	// 글 수정 처리
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 삭제 처리
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 상세 조회
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	// 글 목록 검색
	@RequestMapping("/getBoardList")
	public String getBoardList(Board board, Model model) {
		// Model 객체에 검색 결과를 등록해야 JSP화면에서 사용할 수 있다. 
		model.addAttribute("boardList", boardService.getBoardList(board));
		
		// Controller가 문자열을 리턴하면 ViewResovler가 접두사, 접미사를 붙여준다. 
		return "getBoardList";
	}
}









