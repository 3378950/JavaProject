package com.neuedu.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dto.OrderDTO;
import com.neuedu.dto.SimpleOrderItem;
import com.neuedu.entity.OrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;



public class testProduct {
	public static void main(String[] args) {
		OrderService orderService = new OrderServiceImpl();
		
		List<SimpleOrderItem> orderItems = new ArrayList<SimpleOrderItem>();
		
		orderItems.add(new SimpleOrderItem(1, 2, new BigDecimal(2199)));
		orderItems.add(new SimpleOrderItem(7, 20, new BigDecimal(999)));
		OrderDTO orderDTO = new OrderDTO(1, orderItems);
		orderService.createOrder(orderDTO);
	}
}
