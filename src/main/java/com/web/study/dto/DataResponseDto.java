package com.web.study.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class DataResponseDto<T> extends ResponseDto {
	
	private final T data;

	private DataResponseDto(T data) {
		super(true, HttpStatus.OK.value(), "Successfully"); // super -> ResponseDto, HttpStatus.OK.value() -> 200
		this.data = data;
	}

	private DataResponseDto(T data, String message) {
		super(true, HttpStatus.OK.value(), message);
		this.data = data;
	}
	
	public static <T> DataResponseDto<T> of(T data) {
		return new DataResponseDto<T>(data);	// 생성자 호출
	}

	public static <T> DataResponseDto<T> of(T data, String message) {
		return new DataResponseDto<T>(data, message);
	}

	public static <T> DataResponseDto<T> empty() {
		return new DataResponseDto<T>(null);
	}
	
}
