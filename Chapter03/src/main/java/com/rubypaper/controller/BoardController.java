package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.service.BoardService;

@RestController // @Controller + @ResponseBody
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	
	@GetMapping("/hello")
	// @ResponseBody : 리턴되는 문자열은 문자열 그대로, 만약 자바 객체라면 JSON 데이터로 변환하여 HTTP 응답 프로토콜 Body에 출력한다.
	public String hello(String name) {
		System.out.println("---------> hello() 메소드 호출");
		return boardService.hello(name);
	}
	
	@GetMapping("/getBoard")
	public Map<String,Object> getBoard(int seq) {
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("테스트 Title");
		board.setWriter("테스터");
		board.setContent("테스트 내용....");
		board.setRegDate(new Date());
		board.setCnt(15);
		return boardService.getBoard(seq);
	}
	
	@GetMapping("/getBoardList")
	public List<Map<String,Object>> getBoardList() {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(int i=1; i <= 5; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("테스트 제목 : Title"+i);
			board.setWriter("테스터");
			board.setContent("테스트 내용...."+i);
			board.setRegDate(new Date());
			board.setCnt(15);
			boardList.add(board);
		}
		return boardService.getBoardList();
	}
}





