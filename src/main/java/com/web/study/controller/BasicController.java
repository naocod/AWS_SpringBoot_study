package com.web.study.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;

@RestController
public class BasicController {
	
//	@RequestMapping(value = "/view/test", method = RequestMethod.GET)
	// @ResponseBody ViewResolver한테 가는데 ResponseBody가 있으면 html 파일 명
//	↓ 스프링에서의 추상화
	@GetMapping("/view/test")
	public ResponseEntity<? extends ResponseDto> view() {
	//ResponseDto를 상속받은 것을 와일드카드로 사용
		
		List<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		
		if(strList.contains("e")) {
			try {
				throw new RuntimeException("오류났어!!!!!");
			} catch (Exception e) {
				return ResponseEntity.internalServerError().body(ErrorResponseDto.of(HttpStatus.INTERNAL_SERVER_ERROR, e));	// internalServerError -> 500에러

			}
		}

		return ResponseEntity.ok().body(DataResponseDto.of(strList)); 
		// 응답이 될 때 ok를 날려주면 데이터가 아닌 status가 영향을 받아서 200으로 뜸
		// .badRequest().body 날리면 status 400으로 뜸
	}
}
