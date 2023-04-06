package com.web.study.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.BasicTestDto;

import lombok.Data;

@Data
// setter해서 들어오는거이기 때문에 data 필요
class Params {
	private int age;
	private String name;
}

@RestController
public class BasicRestController {
	
	// GET 요청의 param을 처리하는 방법
//	@GetMapping("/read")
//	public ResponseEntity<? extends ResponseDto> read(
//			@RequestParam("age") int userAge,
//			@RequestParam("name") String userName) {
//		
//		String userInfo = userName + "(" + userAge + ")";
//		
//		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
//	}
	
	// 원래는 param을 받으려면 @RequestParam 적고 키값을 적어줘야하는데 @RequestParam 생략하려면 키값이 변수명이 되면 아래와 같이 작성 가능
	
// =============================================================================================================================================
	
//	@GetMapping("/read")
////	public ResponseEntity<? extends ResponseDto> read(int age, String name) {
//	// 변수가 여러개라면 매개변수에 순서를 맞춰서 다 입력해줘야하는 번거로움을 덜기 위해 매개변수를 따로 모아서 객체를 생성함
//	public ResponseEntity<? extends ResponseDto> read(Params params) {
//		
//		String userInfo = params.getName() + "(" + params.getAge() + ")";
//		
//		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
//		//ResponseEntity에서 body가 제네릭
//		//ResponseEntity는 status header body를 응답할 때 설정해주기 위해서 사용
//		// body에 데이터를 넣어 보내는건 프론트와 정해진 규칙으로 소통하기 위함 -> 인터페이스
//	}
	
// =============================================================================================================================================
	
	@GetMapping("/read")
	public ResponseEntity<? extends ResponseDto> read(BasicTestDto basicTestDto) {
		// BasicTestDto basicTestDto -> get/post만 됨 put, delete안됨
		
		String userInfo = basicTestDto.getName() + "(" + basicTestDto.getAge() + ")";
		
		return ResponseEntity.ok().body(DataResponseDto.of(userInfo));
	}
	
	@GetMapping("/read2/{id}")
//	public ResponseEntity<? extends ResponseDto> read2(@PathVariable("id") int userId) {
	public ResponseEntity<? extends ResponseDto> read2(@PathVariable int id) {
		// @PathVariable int id -> get/post/put/delete 다 됨
		
		Map<Integer, String> userMap = new HashMap<>();
		
		userMap.put(1, "nao1");
		userMap.put(2, "nao2");
		userMap.put(3, "nao3");
		userMap.put(4, "nao4");
		userMap.put(5, "nao5");
		
		return ResponseEntity.ok().body(DataResponseDto.of(userMap.get(id)));
	}
	
	// Post요청의 데이터 처리
	@PostMapping("/create")
	public ResponseEntity<? extends ResponseDto> create(@RequestBody BasicTestDto basicTestDto) {
		// JSON데이터를 받을 때는 항상 @RequestBody를 붙여줌
		// form 데이터를 받을 때는 @RequestBody를 떼어줘야 함
		
		System.out.println("데이터 추가");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(basicTestDto));
	}
}











