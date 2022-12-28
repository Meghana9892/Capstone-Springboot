package com.spring.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Cart;
import com.spring.model.Product;
import com.spring.model.User;
import com.spring.service.Cartservice;

@RestController
@CrossOrigin(origins="*")
public class CartController {

	@Autowired
	private Cartservice cartservice;
	
	@PostMapping("/addcart")
	public String addtoCart(@RequestBody Product product)
	{
		String output = cartservice.addtoCart(product);
		
		
	
		return output;
	}
	
	@GetMapping("/cart")
	public List<Cart> viewCart()
	{
		List<Cart> cart = null;
		List<Cart> cartitems = cartservice.viewCart();;
		if(cartitems.size()==0)
		{
			return cart;
		}
		return cartitems;
		
	}
	@GetMapping("/carttotal")
	public int viewcarttotal()
	{
		int carttotal= cartservice.cartTotal();
		return carttotal;
		
	}
}
