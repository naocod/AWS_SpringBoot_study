package com.web.study.controller.lecture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseService courseService;
	
	@PostMapping("/course")
	public ResponseEntity<? extends ResponseDto> registCourse(@RequestBody CourseReqDto courseReqDto) {
		System.out.println(courseReqDto);
		
		courseService.registeCourse(courseReqDto);
		
		return ResponseEntity.ok().body(ResponseDto.ofDefault());
	}
	
	@GetMapping("/course/all")
	public ResponseEntity<? extends ResponseDto> getCourseAll() {
	
		return ResponseEntity.ok().body(DataResponseDto.of(courseService.getCourseAll()));
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<? extends ResponseDto> getCourseById(@PathVariable int id) {
	
		return ResponseEntity.ok().body(DataResponseDto.of(courseService.findCourseById(id)));
	}

}
