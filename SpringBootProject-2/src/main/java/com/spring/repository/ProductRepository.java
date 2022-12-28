package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findBycuisine(String cuisine);
	
	@Query(value = "SELECT e FROM Product e where productname like ?1%")	
	   public List<Product> findAllSortedByName(@Param("search") String search);
}
