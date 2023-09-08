package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest //@Controller , @RestController만 메모리에 띄운다. 가짜 서블릿 컨테이너를 모킹한다.
class BoardControllerTest1 {

	//@MockMvc가 가짜 서블릿 컨테이너다.
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void contextLoads() {
	}
	
	void testHello() throws Exception{
		// HTTP(http://localhost:8080/hello?name=gurum) 요청을 전송한다.
		// 가짜 서블릿 컨테이너에 가짜로 요청을 함.
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").param("name","gurum"))
		
		//HTTP 응답 결과를 검증한다.
		.andExpect(MockMvcResultMatchers.status().isOk()) // 200
		.andExpect(MockMvcResultMatchers.content().string("hello : gurum"));
	}

}


