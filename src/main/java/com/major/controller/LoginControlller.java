package com.major.controller;

import com.major.respository.RoleRepository;
import com.major.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControlller {
    @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
	UserRepository userRepository;
    @Autowired
	RoleRepository roleRepository;

    @GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}

}
