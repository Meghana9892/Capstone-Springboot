package com.spring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Admin;
import com.spring.model.Product;
import com.spring.model.*;
import com.spring.service.*;

@RestController
@CrossOrigin(origins="*")
public class AdminController {

	@Autowired
	private Adminservice aservice;
	
	@Autowired
	private Userservice uservice;
	
	@Autowired
	private Purchaseservice pservice;
	
	@PostMapping("/admin")
	public String adminlogin(@RequestBody Admin admin)
	{
		boolean result = aservice.addadmin(admin);
		String output="false";
		
		if(result)
		{
			output="true";
		}
		
		return output;
	}
	
	@GetMapping("/users")
	public List<User> getuserpage()
	{
		return uservice.getUsers();
	}
	
	@GetMapping("/orderhistory")
	public List<Purchase> getorderhistoryPage()
	{
		return pservice.viewhistory();
	}
	
	
	
	@PostMapping("/orders")
	public List<Purchase> ordersbyUser(@RequestBody String search)
	{
		User user = uservice.getUser(search);
		List<Purchase> purchases = null;
		if(user==null)
		{
			return purchases;
		}
		else
		{
		return pservice.getPurchasebyUser(user);
		}
		
		
		
	}
	
	@PostMapping("/adminpassword")
	public String changePasswordpage(@RequestBody Admin admin)
	{
		aservice.changepassword(admin);
		return "Password changed sucessfully";
		
	}
	
}

