package com.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Cart;
import com.spring.model.Purchase;
import com.spring.model.User;
import com.spring.repository.PurchaseRepository;

@Service
public class Purchaseservice {

	@Autowired
	private PurchaseRepository prepo;
	
	@Autowired
	private Cartservice cartservice;
	
	@Autowired
	private Userservice uservice;
	
	public boolean buy(User user)
	{
		boolean output = false;
		List<Cart> cart = cartservice.viewCart();
		
		  Date date = new Date();
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	      String strdate = formatter.format(date);
		
		
		for(Cart c:cart)
		{	
			Purchase p = new Purchase();
			p.setProductname(c.getProduct().getProductname());
			p.setPurchasedate(strdate);
			p.setQuantity(c.getQty());
			p.setTotalprice(c.getTotalprice());
			p.setUser(user);
			prepo.save(p);
			output = true;
		}
		return output;
	}
	
	public List<Purchase> viewpurchase(String email)
	{
		User user = uservice.getUser(email);
		
		List<Purchase> purchases = prepo.findByUser(user);
		
		return purchases;
		
	}
	
	public List<Purchase> viewhistory()
	{
		return prepo.findAll();
	}
	
	public List<Purchase> getPurchasebyUser(User user)
	{
		return prepo.findByUser(user);
	}
	
}
