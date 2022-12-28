package com.spring.model;

import javax.persistence.*;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminid;
	private String adminname;
	private String password;
	
	public Admin() {
		super();
	}

	public Admin(int adminid, String adminname, String password) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
