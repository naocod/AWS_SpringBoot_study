package com.web.study.domain.entity;

import java.time.LocalDate;

import com.web.study.dto.response.CourseRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Course {
	private int csm_id;
	private int ltm_id;
	private int sdm_id;
	private LocalDate registe_date;
	private Lecture lecture;
	private Student student;
	
	
	public CourseRespDto toDto() {
		return CourseRespDto.builder()
				.id(csm_id)
				.lectureId(ltm_id)
				.studentId(sdm_id)
				.registeDate(registe_date)
				.build();
	}

}
