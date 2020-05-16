package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.util.DBUtils;

public class testCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// there is none
		List<Cart> CartList = DBUtils.findAll(Cart.class);
		for (Cart cart : CartList) {
//			System.out.println(cart.getName());
		}
	}

}
