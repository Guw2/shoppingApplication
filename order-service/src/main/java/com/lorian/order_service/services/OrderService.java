package com.lorian.order_service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.lorian.order_service.dto.OrderRequest;
import com.lorian.order_service.entities.Order;
import com.lorian.order_service.entities.OrderLineItems;
import com.lorian.order_service.repositories.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository repo;
	
	public OrderService(OrderRepository repo) {
		this.repo = repo;
	}

	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		order.setOrderLineItemsList(mapToEntity(orderRequest)
				.getOrderLineItemsList());
		
		repo.save(order);
	}
	
	private Order mapToEntity(OrderRequest orderRequest) {
		Order order = new Order();
		List<OrderLineItems> orderLineItemsList = new ArrayList<>();
		
		order.getOrderLineItemsList().stream().forEach(x -> {
			orderLineItemsList.add(new OrderLineItems(
					x.getId(),
					x.getSkuCode(),
					x.getPrice(),
					x.getQuantity()
			));
		});
		
		order.setOrderLineItemsList(orderLineItemsList);
		return order;
	}
	
}
