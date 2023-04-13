package com.web.study.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.auth.LoginReqDto;
import com.web.study.dto.request.auth.RegisteUserReqDto;
import com.web.study.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/auth/register")
	public ResponseEntity<? extends ResponseDto> regist(@RequestBody RegisteUserReqDto registeUserReqDto) {
		authService.duplicatedUsername(registeUserReqDto);	// 중복검사 실행 후 예외 생기면 advice로 넘어가고 예외가 발생하지 않는다면 registeUser로 넘어감
		authService.registeUser(registeUserReqDto);
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<? extends ResponseDto> login(@RequestBody LoginReqDto loginReqDto) {
		
		authService.login(loginReqDto);
		System.out.println(authService.login(loginReqDto));
		
		return ResponseEntity.ok().body(DataResponseDto.of(authService.login(loginReqDto)));
	}
	
}
