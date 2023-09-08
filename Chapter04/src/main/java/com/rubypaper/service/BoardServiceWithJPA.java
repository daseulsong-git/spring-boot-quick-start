package com.rubypaper.service;

import java.util.Date;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Service
public class BoardServiceWithJPA implements ApplicationRunner {

//	@Override // 준영속 테스트 (1)
//	public void run(ApplicationArguments args) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		// 상세 조회
//		Board findBoard = em.find(Board.class, 1);
//		System.out.println("FindBoard는 영속 상태인가1(find) : " + em.contains(findBoard));
//
//		em.detach(findBoard);
//		System.out.println("FindBoard는 영속 상태인가(detach)? : " + em.contains(findBoard));
//
//		tx.begin();
//		// 준영속 객체의 값을 수정한다.
//		findBoard.setTitle("---제목 수정");
//		
//		//merge() 메소드를 통해 영속 상태로 전환
//		//인자로 받은 엔티티의 복사본을 만들어 영속상태로 보내고, 원래 객체는 계속 준영속 상태로 유지한다.
//		Board mergedBoard = em.merge(findBoard);
//		System.out.println("FindBoard는 영속 상태인가? : " + em.contains(findBoard));
//		System.out.println("mergedBoard는 영속 상태인가? : " + em.contains(mergedBoard));
//		tx.commit();
//
//		em.close();
//		emf.close();
//	}

	
	
	@Override // 준영속 테스트 (2)
	public void run(ApplicationArguments args) throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		Board board = new Board();
		board.setTitle("임시 제목");
		board.setWriter("테스터");
		board.setContent("임시 내용");
		board.setSeq(1);
		
		// merge()가 매개변수로 받은 객체의 멤버 변수 중 식별자 값이 있으면 merge()는 UPDATE로 동작한다.
		// merge()가 매개변수로 받은 객체의 멤버 변수 중 식별자 값이 없으면 merge()는 INSERT로 동작한다.
		em.merge(board);
		
		
		tx.begin();

		tx.commit();

		em.close();
		emf.close();
	}
	
	
////	@Override // 글 등록 
//	public void run(ApplicationArguments args) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager e	m = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//
//		tx.begin();
//		for(int i=0; i<=2; i++) {
//			Board board = new Board();
//			board.setTitle("JPA 제목 : "+i);
//			board.setWriter("JPA : "+i);
//			board.setContent("JPA 내용.......:"+i);
//			board.setRegDate(new Date());
//			board.setCnt(i);
//			em.persist(board);
//		}
//		tx.commit();
//		
//		em.close();
//		emf.close();
//	}

//	// 상세 조회 (select는 transaction 불필요)
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		
//		Board board = em.find(Board.class, 1);
//		System.out.println("검색된 게시글 : "+board.toString());
//		
//		em.close();
//		emf.close();
//	}

//		// 수정
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
//			
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//			EntityManager em = emf.createEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			
//			tx.begin();
//			
//			// 수정할 게시글을 검색한다.
//			Board board = em.find(Board.class,1);
//			
//			// 검색한 엔티티를 수정한다.
//			board.setTitle("---수정 제목");
//			board.setContent("---수정 내용");
//			tx.commit();
//			
//			em.close();
//			emf.close();
//		}

//		// 삭제
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
//			
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//			EntityManager em = emf.createEntityManager();
//			EntityTransaction tx = em.getTransaction();
//			
//			tx.begin();
//			
//			// 수정할 게시글을 검색한다.
//			Board board = em.find(Board.class,1);
//			
//			// 검색한 엔티티를 삭제한다.
//			em.remove(board);
//			tx.commit();
//			
//			em.close();
//			emf.close();
//		}

//		// 목록 검색
//		@Override
//		public void run(ApplicationArguments args) throws Exception {
//			
//			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//			EntityManager em = emf.createEntityManager();
//		
//			// 글 목록을 검색한다.
//			String jpql = "select b from Board b order by b.seq desc";
//			List<Board> boardList = em.createQuery(jpql).getResultList();
//			for (Board board : boardList) {
//				System.out.println("---> "+board.toString());
//			}
//			
//			em.close();
//			emf.close();
//		}

}
