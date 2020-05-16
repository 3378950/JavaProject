package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.util.DBUtils;

public class testCategory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Category> categoryList = DBUtils.findAll(Category.class);
		for (Category category : categoryList) {
			System.out.println(category.getName());
		}
	}

}
