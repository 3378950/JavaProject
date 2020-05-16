package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Order;
import com.neuedu.entity.OrderItem;
import com.neuedu.util.DBUtils;

public class testOrderItem {
	public static void main(String[] args) {
		// there is none
		List<OrderItem> orderItemList = DBUtils.findAll(OrderItem.class);
		for (OrderItem orderItem : orderItemList) {
//			System.out.println(orderItem.getName());
		}
	}
}
