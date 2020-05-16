package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Product;
import com.neuedu.util.DBUtils;

public class testProduct {
	public static void main(String[] args) {
		List<Product> productList = DBUtils.findAll(Product.class);
		for (Product product : productList) {
			System.out.println(product.getName());
		}
	}
}
