package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;
import com.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	
	@GetMapping("/")
	public String listUsers() {
		return "Index";
	}
	
	@GetMapping("newuser")
	public String Newusers() {
		return "NewUsers";
	}
	
	@PostMapping("saveuser")
	public String saveUser(UserEntity userEntity) {
		userRepository.save(userEntity);
		return "";
	}
	
	@GetMapping("listuser")
	public String ShowUserlist(Model model) {
		List<UserEntity> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "ListUsers";
	}
	
	@GetMapping("deleteuser")
	public String deleteUser(@RequestParam("id") Integer id) {
		userRepository.deleteById(id);
		return "redirect:/listuser";
	}
	
	
}
