package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Cart;
import com.spring.model.Product;
import com.spring.repository.CartRepository;

@Service
public class Cartservice {
	
	@Autowired
	private CartRepository crepo;
	
	
	public String addtoCart(Product p)
	{
		Cart cart = new Cart();
		String output=null;
		Cart c=null;
		int qty;
		int price;
		
		List<Cart> cartitems = viewCart();
		
		if(cartitems.size()==0)
		{
			cart.setProduct(p);
			cart.setQty(1);
			cart.setTotalprice(p.getPrice());
			crepo.save(cart);
			output="Added to cart";
		}
		
		else
		{
			 c = crepo.findByProduct(p);
		
		if(c!=null)
		{
			qty = c.getQty()+1;
			price = c.getProduct().getPrice()*qty;
			c.setQty(qty);
			c.setTotalprice(price);
			crepo.save(c);
			output = "Added to Cart";
		}
		else
		{
			cart.setProduct(p);
			cart.setQty(1);
			cart.setTotalprice(p.getPrice());
			crepo.save(cart);
			output="Added to cart";
		}
		}
		return output;
		
	}
	
	public List<Cart> viewCart()
	{
		return crepo.findAll();
	}
	
	public int cartTotal()
	{
		int total=0;
		
		List<Cart> cartitems = crepo.findAll();
		
		for(Cart c:cartitems)
		{
			total = total + c.getTotalprice();
		}
		
		return total;
	}
	
	public void deletecart()
	{
		crepo.deleteAll();
	}

}
