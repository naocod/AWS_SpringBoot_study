package com.web.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.web.study.IocAndDi.TestC;

@Configuration
public class BeanConfig {
	// @Configuration은 Bean을 등록해주는 용도
	// @Component를 쓰지않고 사용하는이유는 외부 라이브러리사용 시...?
	
	@Bean
	public TestC testC() { // testC 메소드 명이 컴포넌트 name이 되고 new 해서 return한 녀석을 ioc에 ..????????
		return new TestC();
	}
}
