package com.neuedu.dto;

import java.math.BigDecimal;
import java.util.List;

public class SimpleOrderItem {
	private int productId;
	private int count;
	private BigDecimal price;
	public SimpleOrderItem() {
		super();
	}
	public SimpleOrderItem(int productId, int count, BigDecimal price) {
		super();
		this.productId = productId;
		this.count = count;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "SimpleOrderItem [productId=" + productId + ", count=" + count + ", price=" + price + "]";
	}
	
	
	
}
