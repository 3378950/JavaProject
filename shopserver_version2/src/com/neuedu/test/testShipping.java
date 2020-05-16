package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Shipping;
import com.neuedu.util.DBUtils;

public class testShipping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// there is none
		List<Shipping> shippingList = DBUtils.findAll(Shipping.class);
		for (Shipping shipping : shippingList) {
//			System.out.println(shipping.getName());
		}
	}

}
