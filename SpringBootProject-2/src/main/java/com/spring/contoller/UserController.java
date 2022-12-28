package com.spring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.User;
import com.spring.service.Userservice;

@RestController
@CrossOrigin(origins="*")
public class UserController {

	@Autowired
	private Userservice uservice;
	
	@PostMapping("/login")
	public boolean loginpage(@RequestBody User user)
	{
		
		return uservice.login(user);
		
	}
	
	@PostMapping("/register")
	public String addUser(@RequestBody User user)
	{
		boolean output = uservice.adduser(user);
		String result=null;
		
		if(output)
		{
			result="User registered successfully";
		}
		else
		{
			result="User exists";
		}
		return result;
		
	
		
	}
	
	@PostMapping("/user")
	public String getUser(@RequestBody String email)
	{
		
		User user = uservice.getUser(email);
		String username = user.getFirstname().concat(user.getLastname());
		return username;
	}
	
	@PostMapping("/password")
	public String changepasswordpage(@RequestBody User user)
	{
	
		uservice.changepassword(user);
		return "password changed successfully";
	}
}
