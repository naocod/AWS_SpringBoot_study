package com.web.study.domain.entity;

import com.web.study.dto.response.LectureRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Lecture {
	private int ltm_id;
	private String ltm_name;
	private int ltm_price;
	private int itm_id;
	private Instructor instructor;
	
	
	public LectureRespDto toDto() {
		
		String instuctorName = null;
		
		if(instructor != null) {
			instuctorName = instructor.getItm_name();
		}
		
		return LectureRespDto.builder()
				.lectureId(itm_id)
				.lectureName(ltm_name)
				.lecturePrice(ltm_price)
				.instructorName(instuctorName)
				.build();
	}
	
}
