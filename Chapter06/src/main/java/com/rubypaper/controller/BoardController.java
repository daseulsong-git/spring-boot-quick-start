package com.rubypaper.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
	
	// 글 수정
	@GetMapping("/updateBoard")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	// 글 등록
	@PostMapping("/insertBoard")
	public String insertBoard(Board board, @RequestBody MultipartFile uploadFile) throws Exception {
		
		// 파일 업로드
		if(!uploadFile.isEmpty()) {
			uploadFile.transferTo(new File("C:/DEV/upload_files/"+uploadFile.getOriginalFilename()));
		}
		
		boardService.insertBoard(board);
		//리턴되는 View 이름 앞에 "forward:"이나 "redirect:"를 붙이면 ViewResolver가 동작하지 않는다.
		return "redirect:getBoardList";
	}
	
	// 글 삭제
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
		System.out.println("============> 삭제삭제삭제 : "+board.getTitle());
		boardService.deleteBoard(board);
		return "redirect:getBoardList";
	}
	
	// 글 상세 조회
	@GetMapping("/getBoard")
	public String getBoard(Board board, Model model) {
		// Model 객체에 검색 결과를 등록해야 JSP화면에서 사용할 수 있다. 
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	// 글 목록 조회
	@RequestMapping("/getBoardList")
	public String getBoardList(Board board, Model model) {
		
		// Model 객체에 검색 결과를 등록해야 JSP화면에서 사용할 수 있다. 
		model.addAttribute("boardList", boardService.getBoardList(board));
		
		// Controller가 문자열을 리턴하면 ViewResovler가 접두사, 접미사를 붙여준다. 
		return "getBoardList";
	}
}









