package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Admin;
import com.spring.model.Purchase;
import com.spring.model.User;
import com.spring.repository.AdminRepository;


@Service
public class Adminservice {

	@Autowired
	private AdminRepository arepo;
	
	public boolean addadmin(Admin a)
	{
		List<Admin> admin = arepo.findAll();
		boolean output=false;
		boolean result=false;
		
		if(admin.size()==0)
		{
			if((a.getAdminname().equalsIgnoreCase("admin"))&&(a.getPassword().equalsIgnoreCase("admin")))
			{
			arepo.save(a);
			result= true;
			}
			else {
				result=false;
			}
		}
		else
		{
			if((a.getAdminname().equalsIgnoreCase("admin"))&&(a.getPassword().equalsIgnoreCase("admin")))
			{
			result= true;
			}
			else {
				result=false;
			}
		}
		
		return result;
	}
	

	public void changepassword(Admin admin)
	{		
		List<Admin> admin1= arepo.findAll();
		for(Admin a:admin1)
		{
			a.setPassword(admin.getPassword());
			arepo.save(a);
		}
		
	}
	
	
}
