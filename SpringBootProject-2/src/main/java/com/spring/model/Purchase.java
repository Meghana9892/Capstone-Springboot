package com.spring.model;

import javax.persistence.*;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int purchaseid;
	
	private String productname;
	private int quantity;
	private int totalprice;
	
	private String purchasedate;
	
	@OneToOne
	private User user;
	
	

	public Purchase() {
		super();
	}
	
	

	public Purchase(int purchaseid, String productname, int quantity, int totalprice, String purchasedate, User user) {
		super();
		this.purchaseid = purchaseid;
		this.productname = productname;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.purchasedate = purchasedate;
		this.user = user;
	}



	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getPurchasedate() {
		return purchasedate;
	}

	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
