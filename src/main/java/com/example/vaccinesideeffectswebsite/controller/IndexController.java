package com.example.vaccinesideeffectswebsite.controller;

import com.example.vaccinesideeffectswebsite.model.User;
import com.example.vaccinesideeffectswebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({""})
@org.springframework.web.bind.annotation.RestController
public class IndexController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping("/joinProc")
	public void joinProc(User user) {
		System.out.println("회원가입 진행 : " + user);
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setUsername(user.getUserFirstName() + " " + user.getUserSecondName());
		user.setUserFirstName(user.getUserFirstName());
		user.setUserSecondName(user.getUserSecondName());
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		userRepository.save(user);
	}
}

// test after merge