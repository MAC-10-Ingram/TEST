package com.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happyhouse.model.UserInfoDto;
import com.happyhouse.service.UserService;
import com.happyhouse.util.JwtTokenProvider;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenProvider provider;
	
	@GetMapping("/{id}")
	public UserInfoDto selectOne(@PathVariable String id, @RequestBody String token) throws Exception {
		return userService.selectUser(id);
	}

	@PostMapping("/")
	public void register(UserInfoDto userInfoDto) throws Exception {
		userService.signUp(userInfoDto);
	}

	@GetMapping("/login")
	public String login(UserInfoDto userInfoDto) throws Exception {
		UserInfoDto info = userService.login(userInfoDto);
		if(info == null) return "";
		
		return provider.makeJwtToken(info);
		
	}
	
	@GetMapping("/checkToken")
	public String checkToken(String jwt,String id) throws Exception {
		return provider.checkToken(jwt, id)+"";
		
	}
	
	@PutMapping("/update")
	public void updateUser(UserInfoDto userInfoDto) throws Exception {
		userService.updateUser(userInfoDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) throws Exception {
		userService.deleteUser(id);
	}
	
}
