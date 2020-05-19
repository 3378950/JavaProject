package com.neuedu.dao.impl;


import java.util.List;

import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Product;
import com.neuedu.util.DBUtils;

public class ProductDaoImpl implements ProductDao {
	public List<Product> ListProductByLimit() {
		return DBUtils.findAll(Product.class);
	}
}
