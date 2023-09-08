package com.rubypaper;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rubypaper.domain.BoardVO;

// Controller 뿐만 아니라 Service, Repository도 모두 생성해라
// Random_port로 Tomcat 서버를 구동해라
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class BoardControllerTest3 {

	//TestRestTemplate 객체는 웹 브라우저와 동일한 기능을 제공한다.
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		String result = restTemplate.getForObject("/hello?name=gurum",String.class);
		assertEquals("hello : gurum", result);
	}
	
	@Test
	void testGetBoard() {
		BoardVO board = restTemplate.getForObject("/getBoard",BoardVO.class);
		assertNotNull(board);
		assertEquals("테스터", board.getWriter());
	}
	
	@Test
	void testGetBoardList() {
		List<BoardVO> boardList = restTemplate.getForObject("/getBoardList",List.class);
		assertNotNull(boardList);
		assertEquals(5, boardList.size());
	}
}

