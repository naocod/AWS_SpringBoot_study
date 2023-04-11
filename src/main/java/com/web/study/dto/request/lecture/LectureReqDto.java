package com.web.study.dto.request.lecture;

import com.web.study.domain.entity.Lecture;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class LectureReqDto {
	private String lectureName;
	private int lecturePrice;
	private int instructorId;
	
	public Lecture toEntity() {
		return Lecture.builder()
				.ltm__name(lectureName)
				.ltm__price(lecturePrice)
				.itm_id(instructorId)
				.build();
	}

}
