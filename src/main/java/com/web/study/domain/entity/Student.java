package com.web.study.domain.entity;

import java.time.LocalDate;

import com.web.study.dto.response.StudentRespDto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
//@Alias("S1")
public class Student {
	private int id;
	private String name;
	private LocalDate birth_date;
	
	// Allargu를 쓰면 전체를 생성해줘야하기 때문에 필요한 것만 생성하기 위해 builder로 생성 + getter 필수
	
	public StudentRespDto toDto() {
		return StudentRespDto.builder()
				.id(id)
				.name(name)
				.birthDate(birth_date)
				.build();
	}
}
