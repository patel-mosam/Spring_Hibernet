package com.controller;

import java.util.List;
import java.util.Optional;

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


	@GetMapping("edituser")
	public String EditUsers(@RequestParam Integer userId , Model model) {
		
		Optional<UserEntity> optional = userRepository.findById(userId);
		
		if(optional.isEmpty()) {
			return "redirect:/listuser";
		}else {
			model.addAttribute("user",optional.get());
			return "EditUser";
		}
		
	}
	
	@PostMapping("updateuser")
	public String updateUser(UserEntity userEntity) {
	    userRepository.save(userEntity);
	    return "redirect:/listuser";
	}

	@GetMapping("searchuser")
	public String SearchUsers() {
		
		return "SearchUser";
	}
	
	@PostMapping("searchuser")
	public String SearchUserDb(UserEntity userEntity , Model model) {
		
		String firstName = userEntity.getFirstName();
		
		String lastName = userEntity.getLastName();
//		List<UserEntity> users = userRepository.findByfirstName(firstName);
		
		List<UserEntity> users = userRepository.findByfirstName(firstName);
		
//		List<UserEntity> users1 = userRepository.findBylastName(lastName);
		
//		List<UserEntity> users = userRepository.searchByFirstName(firstName+"%");
		
		model.addAttribute("users",users);
		
//		model.addAttribute("users",users1);
		return "SearchUser";
	}
	
	
	
	

}
