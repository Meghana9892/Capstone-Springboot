package com.spring.contoller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.spring.model.Product;
import com.spring.service.Productservice;

@RestController
@CrossOrigin(origins="*")
public class ProductController {

	@Autowired
	private Productservice pservice;
	
	@GetMapping("/products")
	public List<Product> viewProduct()
	{
		List<Product> products = pservice.getProducts();
		return products;
		
	}
	
	@GetMapping("/sort")
	public List<Product> sortbyPrice()
	{
		List<Product> products = pservice.sortbyPriceAsc();
		return products;
		
	}
	
	@GetMapping("/productname")
	public List<Product> sortbyProductname()
	{
		List<Product> products = pservice.sortbyNameAsc();
		return products;
		
	}
	
	@PostMapping("/search")
	public List<Product> searchbyProductname(@RequestBody String search)
	{
		List<Product> products = pservice.searchby(search);
		List<Product> prod = null;
		if(products.size()==0)
		{
			return prod;
		}
		else
		{
		return  products;
		}
		
		
		
	}
	
	@PostMapping("/cuisine")
	public List<Product> viewProductbycuisine(@RequestBody String cuisine)
	{
		List<Product> products = pservice.getProductsbycuisine(cuisine);
		List<Product> prod = null;
		if(products.size()==0)
		{
			return prod;
		}
		else
		{
		return  products;
		}
		
		
	}
	
	@PostMapping("/addproduct")
	public String addProduct(@RequestBody Product p)
	{
		pservice.addproduct(p);
		
		return "Product added";
		
	}
	
	@PutMapping("/save")
	public String editProduct(@RequestBody Product p)
	{
		pservice.editproduct(p);
		
		return "Product added";
		
	}
	
	@PostMapping("/delete")
	public String deleteProduct(@RequestBody Product p)
	{
		pservice.deleteproduct(p);
		return "Product deleted";
		
	}
    
}

