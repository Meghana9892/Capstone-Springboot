package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.model.Product;
import com.spring.repository.ProductRepository;

@Service
public class Productservice {

	@Autowired
	private ProductRepository prepo;
	
	public List<Product> getProducts()
	{
		List<Product> products = prepo.findAll();
		return products;
		
	}
	
	public List<Product> getProductsbycuisine(String cuisine)
	{
		List<Product> products = prepo.findBycuisine(cuisine);
		return products;
		
	}
	
	public void addproduct(Product p)
	{
		prepo.save(p);
		
	}
	
	public void addproductwithimage(Product p,MultipartFile image)
	{
		
		prepo.save(p);
		
	}
	
	public void editproduct(Product p)
	{
		
		Optional<Product> p1 = prepo.findById(p.getProductid());
		Product product = p1.get();
		
		if(product!=null)
		{	
			prepo.save(p);
		}
	}
	
	public void deleteproduct(Product p)
	{
		prepo.delete(p);
		
	}
	
	public List<Product> sortbyPriceAsc()
	{
		List<Product> sortedproducts = prepo.findAll(Sort.by(Sort.Direction.ASC, "price"));
		return sortedproducts;
		
	}

	
	public List<Product> sortbyNameAsc()
	{
		List<Product> sortedproducts = prepo.findAll(Sort.by(Sort.Direction.ASC, "productname"));
		return sortedproducts;
		
	}
	
	public List<Product> searchby(String search)
	{
		List<Product> products = prepo.findAllSortedByName(search);
		return products;
		
	}
}