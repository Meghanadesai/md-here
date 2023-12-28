package com.rest.webservice.restfulwebservice.User;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	private UserDaoService userDaoService;
	
	public UserResource(UserDaoService userDaoService) {
		this.userDaoService = userDaoService;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDaoService.findAll();		
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}

	@PostMapping("/users")
	public void createUser(){

	}
}
