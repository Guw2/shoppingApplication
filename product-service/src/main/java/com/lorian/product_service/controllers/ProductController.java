package com.lorian.product_service.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lorian.product_service.dto.ProductRequest;
import com.lorian.product_service.dto.ProductResponse;
import com.lorian.product_service.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private final ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponse>> getAll(){
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}
	
}
