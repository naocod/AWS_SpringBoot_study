package com.web.study.dto.request.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.web.study.domain.entity.User;

import lombok.Data;

@Data
public class RegisteUserReqDto {
	
	private String username;
	private String password;
	private String name;
	private String email;

	public User toEntity() {
		return User.builder()
				.username(username)
				.password(new BCryptPasswordEncoder().encode(password)) // -> BCryptPasswordEncoder가 암호화해줌 > 시큐리티가 알아서 복호화해줌
				.name(name)
				.email(email)
				.build();
	}
	
}
