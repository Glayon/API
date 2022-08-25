package com.glayon.API.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glayon.API.exceptionhandler.ClientApiException;
import com.glayon.API.model.Product;
import com.glayon.API.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductRepository productRepository;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product) {

		productRepository.save(product);

		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}

	@GetMapping("/lista")
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(productRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		
		Product product = productRepository.findById(id).
				orElseThrow(() -> new ClientApiException("Registro não encontrado com o id " + id));
		
		return ResponseEntity.ok(product);
	}
}
