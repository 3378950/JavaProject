package com.neuedu.test;

import java.util.List;

import com.neuedu.entity.Product;
import com.neuedu.entity.User;
import com.neuedu.util.DBUtils;

public class testUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> userList = DBUtils.findAll(User.class);
		for (User user : userList) {
			System.out.println(user);
		}
	}

}
