package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Order;
import com.neuedu.util.DBUtils;

public class testOrder {
	public static void main(String args[]) {
		// there is none
		List<Order> orderList = DBUtils.findAll(Order.class);
		for (Order order : orderList) {
//			System.out.println(order.getName());
		}
	}
}
