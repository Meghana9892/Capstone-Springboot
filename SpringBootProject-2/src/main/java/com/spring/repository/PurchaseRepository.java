package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Purchase;
import com.spring.model.User;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

	
	List<Purchase> findByUser(User user);
}
