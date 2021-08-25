package com.major.controller;

import com.major.global.GlobalData;
import com.major.model.Role;
import com.major.model.User;
import com.major.respository.RoleRepository;
import com.major.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
		GlobalData.cart.clear();

		return "login";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request)throws ServletException
	{
		String password= user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail(),password);
		return "redirect:/";
	}

}
