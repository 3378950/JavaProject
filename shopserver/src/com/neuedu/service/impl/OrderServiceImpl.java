package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dto.OrderDTO;
import com.neuedu.dto.SimpleOrderItem;
import com.neuedu.entity.Product;
import com.neuedu.service.OrderService;
import com.neuedu.util.DBUtils;

public class OrderServiceImpl implements OrderService{
	public void createOrder(OrderDTO orderDTO) {
		System.out.println(orderDTO.getOrderItems());
		
		List<SimpleOrderItem> orderItems = orderDTO.getOrderItems();
		for (SimpleOrderItem simpleOrderItem : orderItems) {
			Product product = DBUtils.findById(simpleOrderItem.getProductId());
			System.out.println(product.getName());
			if(product.getStock() < simpleOrderItem.getCount()) {
				System.out.println("sold out");
			} else {
				System.out.println("ok");
				System.out.println("stock :" + product.getStock());
			}
		}
		return ;
	}
}
