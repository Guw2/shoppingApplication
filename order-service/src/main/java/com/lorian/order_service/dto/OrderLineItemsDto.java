package com.lorian.order_service.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderLineItemsDto {
	
	private Long id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;
	
	public OrderLineItemsDto() {}

	public OrderLineItemsDto(Long id, String skuCode, BigDecimal price, Integer quantity) {
		this.id = id;
		this.skuCode = skuCode;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderLineItemsDto [id=" + id + ", skuCode=" + skuCode + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, price, quantity, skuCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderLineItemsDto other = (OrderLineItemsDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(price, other.price)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(skuCode, other.skuCode);
	}
	
}
