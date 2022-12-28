package com.spring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.*;
import com.spring.service.*;

@RestController
@CrossOrigin(origins="*")
public class PurchaseController {

	@Autowired
	private Purchaseservice pservice;
	
	@Autowired
	private Userservice uservice;
	
	@Autowired
	private Cartservice cservice;
	
	@PostMapping("/buy")
	public String viewProductbycuisine(@RequestBody String email)
	{
		
		User user = uservice.getUser(email);
		
		boolean output = pservice.buy(user);
		
		String result=null;
		
		if(output)
		{
			cservice.deletecart();
			result="null";
			
		}
		else
		{
			result= "Cart is empty";
		}
		
		return result;
	}
	
	@PostMapping("/purchases")
	public List<Purchase> viewProduct(@RequestBody String email)
	{
		List<Purchase> purchases = pservice.viewpurchase(email);
		return purchases;
		
	}
}
