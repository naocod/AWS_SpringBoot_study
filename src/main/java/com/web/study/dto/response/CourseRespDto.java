package com.web.study.dto.response;

import java.time.LocalDate;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Student;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class CourseRespDto {
	private int courseId;
	private LocalDate registeDate;
	private String lectureName;
	private int lecturePrice;
	private String instructorName;
	private String studentName;
	
}
