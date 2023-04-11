package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.lecturer.LecturerReqDto;
import com.web.study.dto.response.LecturerRespDto;
import com.web.study.repository.LecturerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {
	
	private final LecturerRepository lecturerRepository ;

	@Override
	public void registeLecturer(LecturerReqDto lecturerReqDto) {
		
		System.out.println(lecturerReqDto);
		lecturerRepository.saveLecturer(lecturerReqDto.toEntity());
		
	}

	@Override
	public List<LecturerRespDto> getLecturerAll() {
		List<LecturerRespDto> dtos = new ArrayList<>();
		
		lecturerRepository.getLecturerAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
		// 다른 형태의 list이기 때문에 새로운 List에 forEach로 하나씩 꺼내서 더해줌
		//lecturerRepository.getLecturerAll() -> lecturer Entity List
	}
	
	@Override
	public LecturerRespDto findLecturerById(int id) {
		return lecturerRepository.findLecturerById(id).toDto();
	}

}
