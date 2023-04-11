package com.web.study.domain.entity;

import java.time.LocalDate;

import com.web.study.dto.response.CourseRespDto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Course {
	private int id;
	private int lecture_id;
	private int student_id;
	private LocalDate registe_date;
	private Lecture lecture;
	private Student student;
	
	
	public CourseRespDto toDto() {
		return CourseRespDto.builder()
				.id(id)
				.lectureId(lecture_id)
				.studentId(student_id)
				.registeDate(registe_date)
				.build();
	}

}
