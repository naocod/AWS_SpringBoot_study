package com.web.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
//		iocAndDiTest();
	}
	
//	public static void iocAndDiTest() {
//		// 외부에서 매개변수로 부품 생성 -> 의존성 주입
//		// Inversion of Control -> 제어의 역전
//		// 제어를 개발자가 안하고 프로그램이 함
//		IocTest iocTest = new IocTest(new TestB());
//		iocTest.run();
//	}

}
