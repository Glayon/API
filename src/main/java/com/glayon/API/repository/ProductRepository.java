package com.glayon.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glayon.API.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
