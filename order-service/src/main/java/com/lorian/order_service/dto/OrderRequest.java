package com.lorian.order_service.dto;

import java.util.List;
import java.util.Objects;

public class OrderRequest {
	private List<OrderLineItemsDto> orderLineItemsDtoList;
	
	public OrderRequest() {}

	public OrderRequest(List<OrderLineItemsDto> orderLineItemsDtoList) {
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}

	public List<OrderLineItemsDto> getOrderLineItemsDtoList() {
		return orderLineItemsDtoList;
	}

	public void setOrderLineItemsDtoList(List<OrderLineItemsDto> orderLineItemsDtoList) {
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderLineItemsDtoList=" + orderLineItemsDtoList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderLineItemsDtoList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderRequest other = (OrderRequest) obj;
		return Objects.equals(orderLineItemsDtoList, other.orderLineItemsDtoList);
	}
	
}
