package com.spring.model;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productid;
	
	private String productname;
	private String cuisine;
	private int price;
	
	
	public Product() {
		super();
	}


	


	public Product(int productid, String productname, String cuisine, int price) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.cuisine = cuisine;
		this.price = price;
	}





	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public String getCuisine() {
		return cuisine;
	}


	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	
	
	
}
