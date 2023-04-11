package com.web.study.dto.response;

import com.web.study.domain.entity.Instructor;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LectureRespDto {
	private int lectureId;
	private String lectureName;
	private int lecturePrice;
	private String instructorName;
}
