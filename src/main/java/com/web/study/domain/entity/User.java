package com.web.study.domain.entity;

import java.util.ArrayList;
import java.util.List;

import com.web.study.security.PrincialUserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int user_id;
	private String username;
	private String password;
	private String name;
	private String email;
	
	private List<Authority> authorities;	// user는 여려개의 권한을 가질 수 있음
	
	public PrincialUserDetails toPrincipal() {
		List<String> roles = new ArrayList<>();
		
		authorities.forEach(authority -> {
			roles.add(authority.getRole().getRole_name());
		});
		
		return PrincialUserDetails.builder()
				.userId(user_id)
				.username(username)
				.password(password)
				.roles(roles)
				.build();
	}
}
