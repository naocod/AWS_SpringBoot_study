package com.web.study.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Lecture {
	private int ltm_id;
	private String ltm__name;
	private int ltm__price;
	private int itm_id;
	private Instructor instructor;
	
}
