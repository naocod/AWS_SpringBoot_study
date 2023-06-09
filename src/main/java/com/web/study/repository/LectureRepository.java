package com.web.study.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.web.study.domain.entity.Lecture;

@Mapper
public interface LectureRepository {
	
	// insert update delete는 반환자료형이 쿼리 성공갯수이기 때문에 반환자료형이 int
	public int registe(Lecture lecture);
	public List<Lecture> searchLecture(Map<String, Object> parameterMap);

}
