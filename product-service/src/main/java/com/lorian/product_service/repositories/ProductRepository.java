package com.lorian.product_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lorian.product_service.entities.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
