package com.yh.shopping.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yh.shopping.model.RoleType;
import com.yh.shopping.model.User;
import com.yh.shopping.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.ROLE_USER);
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User 로그인(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
	
}
