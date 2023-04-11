package com.web.study.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.study.dto.request.instructor.InstructorReqDto;
import com.web.study.dto.response.InstructorRespDto;
import com.web.study.repository.InstructorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
	
	private final InstructorRepository instructorRepository ;

	@Override
	public void registeInstructor(InstructorReqDto instructorReqDto) {
		
		System.out.println(instructorReqDto);
		instructorRepository.saveInstructor(instructorReqDto.toEntity());
		
	}

	@Override
	public List<InstructorRespDto> getInstructorAll() {
		List<InstructorRespDto> dtos = new ArrayList<>();
		
		instructorRepository.getInstructorAll().forEach(entity -> {
			dtos.add(entity.toDto());
		});
		
		return dtos;
		// 다른 형태의 list이기 때문에 새로운 List에 forEach로 하나씩 꺼내서 더해줌
		//instructorRepository.getInstructorAll() -> instructor Entity List
	}
	
	@Override
	public InstructorRespDto findInstructorById(int id) {
		return instructorRepository.findInstructorById(id).toDto();
	}

}
