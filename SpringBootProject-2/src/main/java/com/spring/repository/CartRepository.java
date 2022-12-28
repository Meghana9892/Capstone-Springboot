package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Cart;
import com.spring.model.Product;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart findByProduct(Product p);
}
