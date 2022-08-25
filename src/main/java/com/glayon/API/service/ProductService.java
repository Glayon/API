package com.glayon.API.service;

import org.springframework.stereotype.Service;

import com.glayon.API.model.Product;

@Service
public interface ProductService {

	void save(Product product);

}
