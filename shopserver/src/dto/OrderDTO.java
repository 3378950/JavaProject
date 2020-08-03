package com.neuedu.dto;

import java.util.List;

import com.neuedu.entity.OrderItem;
import com.neuedu.entity.Product;

public class OrderDTO {
	private Integer userId;
	private List<SimpleOrderItem> orderItems;
	public OrderDTO() {
		super();
	}
	public OrderDTO(Integer userId, List<SimpleOrderItem> orderItems) {
		super();
		this.userId = userId;
		this.orderItems = orderItems;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<SimpleOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<SimpleOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "OrderDTO [userId=" + userId + ", orderItems=" + orderItems + "]";
	}
	
	
	
	
}
