package com.lorian.product_service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lorian.product_service.dto.ProductRequest;
import com.lorian.product_service.dto.ProductResponse;
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
	
	public List<ProductResponse> getAllProducts(){
		List<ProductResponse> lista = new ArrayList<>();
		repo.findAll().forEach(x -> {
			ProductResponse res = new ProductResponse();
			res.setId(x.getId());
			res.setName(x.getName());
			res.setDescription(x.getDescription());
			res.setPrice(x.getPrice());
			lista.add(res);
		});
		return lista;
	}
	
}
