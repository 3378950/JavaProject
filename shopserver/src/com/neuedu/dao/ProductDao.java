package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Product;
/***
 * product interface
 * @author Chenshu
 *
 */
public interface ProductDao {
	public List<Product> ListProductByLimit();
}
