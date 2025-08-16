package com.lorian.product_service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lorian.product_service.dto.ProductRequest;
import com.lorian.product_service.entities.Product;
import com.lorian.product_service.repositories.ProductRepository;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {
	
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper; 

	@Autowired
	private ProductRepository repo;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}
	
	@BeforeEach
	void beforeEach() {
		repo.deleteAll();
	}
	
	@Test
	void shouldGetAllProducts() throws Exception{
		Product product0 = new Product();
		product0.setName("iPhone 14");
		
		Product product1 = new Product();
		product1.setName("Fridge");
		
		repo.save(product0);
		repo.save(product1);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/product"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name").value("iPhone 14"))
			.andExpect(jsonPath("$[1].name").value("Fridge"))
			.andExpect(jsonPath("$.length()").value(2));
	}
	
	@Test
	void shouldCreateProduct() throws Exception {
		
		ProductRequest productRequest = getProductRequest(0);
		String mappedJson = mapper.writeValueAsString(productRequest);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mappedJson)
		).andExpect(status().isCreated());
		
		Assertions.assertTrue(repo.findAll().size() == 1);
	}
	
	private ProductRequest getProductRequest(Integer i) {
		ProductRequest productRequest = new ProductRequest();
		
		if(i == 0) {
			productRequest.setName("iPhone 15");
			productRequest.setDescription("iPhone 15");
			productRequest.setPrice(BigDecimal.valueOf(2000));			
		}else if (i == 1) {
			productRequest.setName("Samsung TV");
			productRequest.setDescription("Samsung TV");
			productRequest.setPrice(BigDecimal.valueOf(1200));
		}
		return productRequest;
	}

}
