package com.rubypaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepository ;
	
	// 글 등록
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}
	
	// 글 수정
	public void updateBoard(Board board) {
		
		// 수정할 Entity를 검색한다.
		Board findBoard = boardRepository.findById(board.getSeq()).get();
		
		// 매개변수로 받은 값으로 변경한다.
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		boardRepository.save(findBoard);
	} 
	
	// 글 삭제
	public void deleteBoard(Board board) {
		boardRepository.deleteById(board.getSeq());
	}
	
	// 글 상세 조회
	public Board getBoard(Board board) {
		return boardRepository.findById(board.getSeq()).get();
	}
	
	// 글 목록 검색
	public List<Board> getBoardList(Board board){
		return boardRepository.findAll();
	}
	
}
