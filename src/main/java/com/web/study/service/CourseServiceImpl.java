package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.course.CourseReqDto;
import com.web.study.dto.response.CourseRespDto;
import com.web.study.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

	private final CourseRepository courseRepository;
	
	@Override
	public void registeCourse(CourseReqDto courseReqDto) {
		
		courseRepository.saveCourse(courseReqDto.toEntity());
		
	}

	@Override
	public List<CourseRespDto> getCourseAll() {
		List<CourseRespDto> dtos = new ArrayList<>();
		
		courseRepository.getCourseAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		return dtos;
	}

	@Override
	public CourseRespDto findCourseById(int id) {
		return courseRepository.fintCourseById(id).toDto();
	}

}
