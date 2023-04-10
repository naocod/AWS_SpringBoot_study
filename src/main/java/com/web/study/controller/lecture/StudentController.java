package com.web.study.controller.lecture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.student.StudentReqDto;
import com.web.study.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class StudentController {
	
	private final StudentService studentService;
	
	// @RequestBody => 클라이언트 -> 서버 데이터 전송(JSON)
	// JSON의 형태 -> 객체
	
	@PostMapping("/student")
	public ResponseEntity<? extends ResponseDto> registeStudent(@RequestBody StudentReqDto studentReqDto) {
		
		studentService.registeStudent(studentReqDto);
		
		return ResponseEntity.ok().body(ResponseDto.ofDefault()); 
	}

}
