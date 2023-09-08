package com.rubypaper;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.rubypaper.service.BoardService;


//프로퍼티 커스터마이징 
@SpringBootTest(properties = {"author.name=Gurum", 
        "author.age=35", 
        "author.nation=KOREA"},
classes = BoardService.class) // 이렇게 class를 지정하면 원하는 class만 메모리에 띄운다.


// @SpringBootTest는 
// 1. @Controller, @Service, @Repository가 붙은 모든 객체를 메모리에 올린다.
// 2. AutoConfiguration 클래스들을 로딩하여 테스트에 필요한 기타 객체들을 메모리에 올린다. 
//@SpringBootTest
public class PropertiesTest {
	
	// 외부에 설정한 테스트 데이터를 가져온다. 테스트 데이터 셋팅 방법 1
	@Value("${author.name}")
	private String name;
	
	@Value("${author.age}")
	private int age;

	public void testMethod() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
	
	
//	//테스트 데이터 셋팅 방법 2
//	@Autowired
//	private Environment env;
//
//	@Test
//	public void testMethod() {
//		System.out.println("이름 : " + env.getProperty("author.name"));
//		System.out.println("나이 : " + env.getProperty("author.age"));
//	}

}