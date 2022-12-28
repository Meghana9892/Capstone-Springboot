package com.spring.model;

import javax.persistence.*;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Product product;
	
	private int qty;
	private int totalprice;
	
	
	public Cart() {
		super();
	}


	public Cart(int cartid, Product product, int qty, int totalprice) {
		super();
		this.cartid = cartid;
		this.product = product;
		this.qty = qty;
		this.totalprice = totalprice;
	}


	public int getCartid() {
		return cartid;
	}


	public void setCartid(int cartid) {
		this.cartid = cartid;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getTotalprice() {
		return totalprice;
	}


	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	

}
