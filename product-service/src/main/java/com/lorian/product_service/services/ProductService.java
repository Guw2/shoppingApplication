package com.lorian.product_service.services;

import org.springframework.stereotype.Service;

import com.lorian.product_service.dto.ProductRequest;
import com.lorian.product_service.entities.Product;
import com.lorian.product_service.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}

	public void createProduct(ProductRequest productRequest) {
		Product product = new Product();
		
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		
		repo.save(product);
		
	}
	
}
