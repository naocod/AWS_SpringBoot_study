package com.web.study.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponseDto extends ResponseDto {
	
	// error는 메세지만 전달해주면 되기때문에 제네릭을 쓰지 않음, 단, 여러개를 전달해줘야 하기 때문에 Map을 사용함
	private Map<String, String> errorData;
	

	private ErrorResponseDto(HttpStatus status) {
		super(false, status.value(), "Failed");
	}

	private ErrorResponseDto(HttpStatus status, Exception e) {
		super(false, status.value(), e.getMessage());
	}

	private ErrorResponseDto(HttpStatus status, Exception e, Map<String, String> errorData) {
		super(false, status.value(), e.getMessage());
		this.errorData = errorData;
	}
	
	public static ErrorResponseDto of(HttpStatus status) {
		return new ErrorResponseDto(status);
	}

	public static ErrorResponseDto of(HttpStatus status, Exception e) {
		return new ErrorResponseDto(status, e);
	}

	public static ErrorResponseDto of(HttpStatus status, Exception e, Map<String, String> errorData) {
		return new ErrorResponseDto(status, e, errorData);
	}

	public static ErrorResponseDto empty() {
		return new ErrorResponseDto(null);
	}
	
}
