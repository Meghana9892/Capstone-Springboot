package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class Userservice {

	@Autowired
	private UserRepository urepo;
	
	public boolean adduser(User u)
	{
		boolean output = false;
		User user = urepo.findByemail(u.getEmail());
		if(user==null)
		{
			urepo.save(u);
			output=true;
		}
		return output;
		
		
	}
	
	public boolean login(User u)
	{
		boolean output=false;
		String email = u.getEmail();
		String password = u.getPassword();
		
		User user = urepo.findByemailAndPassword(email, password);
		
		if(user!=null)
		{
			output=true;
		}
		return output;
		
	}
	
	public User getUser(String email)
	{

		return urepo.findByemail(email);
	}
	
	
	public List<User> getUsers()
	{

		return urepo.findAll();
	}
	
	
	
	public void changepassword(User user)
	{		
		User u = urepo.findByemail(user.getEmail());
		u.setPassword(user.getPassword());
		urepo.save(u);
		
	}
}
