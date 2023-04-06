package com.web.study.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ErrorResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.UserAdditionDto;

class UserStore {
	public static Map<Integer, UserAdditionDto> userMap = new HashMap<>();
}

@RestController
public class UserRestController {
	
	@PostMapping("/api/user/addition")
	public ResponseEntity<? extends ResponseDto> addUser(@RequestBody UserAdditionDto userAdditionDto) {
		Map<Integer, UserAdditionDto> userMap = UserStore.userMap;	// static으로 저장하기 위한 용도, HashMap을 가져와서 대입(주소)
		int maxKey = 0; // 키값 생성
		if(!userMap.keySet().isEmpty()) { // 키값들이 비어있지 않으면 실행
			maxKey = Collections.max(userMap.keySet()); // Collections -> ArrayList set map에 다 쓸 수 있음
			// 키 중에서 가장 큰 값을 maxKey로 넣어줌
		}
		userMap.put(maxKey + 1, userAdditionDto);

		return ResponseEntity.ok().body(DataResponseDto.of(userMap)); // userMap return
	}
	
	@GetMapping("/api/user/{id}")
	public ResponseEntity<? extends ResponseDto> getUser(@PathVariable int id) {
		
		// userMap에서 해당 id를 가진 객체를 응답
		// 만약에 해당 id가 존재하지 않으면 ErrorResponse를 응답으로 준다. errorMessage = 존재하지 않는 id입니다.
		
		Map<Integer,UserAdditionDto> userMap = UserStore.userMap;
		UserAdditionDto userAdditionDto = userMap.get(id);
		
		try {
			if(userAdditionDto == null) {
				throw new RuntimeException("존재하지 않는 id 입니다.");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(ErrorResponseDto.of(HttpStatus.BAD_REQUEST, e));
		}
		
		return ResponseEntity.ok().body(DataResponseDto.of(userAdditionDto));
	}
	
	@GetMapping("/api/users")
	public ResponseEntity<? extends ResponseDto> getUsers() {
		

//		return ResponseEntity.ok().body(DataResponseDto.of(UserStore.userMap.entrySet().stream().collect(Collectors.toCollection(ArrayList::new))));
		
		return ResponseEntity.ok().body(DataResponseDto.of(UserStore.userMap.values()));
		
	}
	

}
