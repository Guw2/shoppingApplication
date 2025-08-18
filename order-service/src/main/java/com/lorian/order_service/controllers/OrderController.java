package com.lorian.order_service.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lorian.order_service.dto.OrderRequest;
import com.lorian.order_service.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService service;
	
	public OrderController(OrderService service) {
		this.service = service;
	}

	@PostMapping
	public void placeOrder(@RequestBody OrderRequest orderRequest) {
		service.placeOrder(orderRequest);
	}
	
}
