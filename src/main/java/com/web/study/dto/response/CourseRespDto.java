package com.web.study.dto.response;

import java.time.LocalDate;

import com.web.study.domain.entity.Lecture;
import com.web.study.domain.entity.Student;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CourseRespDto {
	private int id;
	private int lectureId;
	private int studentId;
	private LocalDate registeDate;
	private Lecture lecture;
	private Student student;
}
