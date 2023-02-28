package com.sachin.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sachin.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{
	
	

}
