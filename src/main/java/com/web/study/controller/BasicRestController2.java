package com.web.study.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.study.dto.DataResponseDto;
import com.web.study.dto.ResponseDto;
import com.web.study.dto.request.MovieDto;

@RestController
public class BasicRestController2 {
	
	@GetMapping("/movie/read")
	public ResponseEntity<? extends ResponseDto> read(String movieTitle) {
		
		return ResponseEntity.ok().body(DataResponseDto.of(movieTitle));
	}
	
	@GetMapping("/movie/read2")
	public ResponseEntity<? extends ResponseDto> read2(MovieDto movieDto) {
		
		String movieInfo = movieDto.getTitle() + "은(는) " + movieDto.getDate() + "에 개봉합니다.";
		
		return ResponseEntity.ok().body(DataResponseDto.of(movieInfo));
	}
	
	@GetMapping("/movie/read3")
	public ResponseEntity<? extends ResponseDto> read3(String title, String date) {
		
		String movieInfo = title + "은(는) " + date + "에 개봉합니다.";
		
		return ResponseEntity.ok().body(DataResponseDto.of(movieInfo));
	}
	
	// ========================================================================
	
	@PostMapping("/movie/create1")
	public ResponseEntity<? extends ResponseDto> createForm(MovieDto movieDto) {
		System.out.println(movieDto.getTitle() + "은(는) " + movieDto.getDate() + "에 개봉합니다.");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(movieDto));
	}
	
	@PostMapping("/movie/create2")
	public ResponseEntity<? extends ResponseDto> createJson(@RequestBody MovieDto movieDto) {
		System.out.println(movieDto.getTitle() + "은(는) " + movieDto.getDate() + "에 개봉합니다.");
		
		return ResponseEntity.created(null).body(DataResponseDto.of(movieDto));
	}
	
	
	
}
