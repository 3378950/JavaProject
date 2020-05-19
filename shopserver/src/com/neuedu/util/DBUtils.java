package com.neuedu.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;
import com.neuedu.entity.Product;
import com.sun.java_cup.internal.runtime.Scanner;

public class DBUtils {
	public static <E> List<E> findAll(Class c) {
		// access the name of table
		Table table = (Table)c.getDeclaredAnnotation(Table.class);
		String tableName = "";		
		if(table == null) {
			tableName = c.getSimpleName();
		} else {
			tableName = table.value();
		}
		// make up the sql
		String sql = "select * from " + tableName;
//		System.out.println(sql);
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<E> list = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?uesSSL=false", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			Field[] fields = c.getDeclaredFields();
			while(rs.next()) {
				
					E e = (E)c.newInstance();
//					System.out.println(e);
				
				for (Field field : fields) {
					String columnName = "";
					Column column = field.getDeclaredAnnotation(Column.class);
					if(column == null) {
						columnName = field.getName();
					} else {
						columnName = column.value();
					}
//					System.out.println(rs.getObject(columnName));
					field.setAccessible(true);
					try {
						field.set(e, rs.getObject(columnName));
					} catch (IllegalArgumentException | IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				list.add(e);
//				System.out.println(e);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			if(psta != null) {
				try {
					psta.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}
		
		return list;
	}
	
	public static void save(Object data) {
		Table table = (Table)data.getClass().getDeclaredAnnotation(Table.class);
		String tableName = "";		
		if(table == null) {
			tableName = data.getClass().getSimpleName();
		} else {
			tableName = table.value();
		}
//		System.out.println(data.attributeToString());
//		String string = data.getClass().attributeToString();
//		System.out.println(tableName);
		
		String sql = "insert into " + tableName;
//		StringBuilder sbValue = new StringBuilder();
		String[] fieldNames = getAttributeName(data);
		
//		for (String string : fieldNames) {
//			System.out.println(string);
//		}
//		Connection conn = null;
//		PreparedStatement psta = null;
//		ResultSet rs = null;
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?uesSSL=false", "root", "root");
//			psta = conn.prepareStatement(sql);
//			rs = psta.executeQuery();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	private static String[] getAttributeName(Object o) {  
        Field[] fields = o.getClass().getDeclaredFields();  
        String[] fieldNames = new String[fields.length];
        int cnt = 0;
        for(Field field: fields) {  
//            System.out.println(fields[i].getType());  
            String columnName = "";
			Column column = field.getDeclaredAnnotation(Column.class);
			if(column == null) {
				columnName = field.getName();
			} else {
				columnName = column.value();
			}
			fieldNames[cnt++] = columnName;
        }  
        return fieldNames;  
    }  
	
	public static Product findById(int id) {
		
		Product result = null;
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		String sql = "select * from pmt_product where id = " + id;
		System.out.println(sql);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop?uesSSL=false", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while(rs.next()) {
				result = new Product(rs.getInt("id"), rs.getInt("category_Id"), rs.getString("name"), 
						rs.getString("subtitle"), rs.getString("main_image"), rs.getString("sub_images"), rs.getString("detail"),
						rs.getBigDecimal("price"), rs.getInt("stock"), rs.getInt("status"), rs.getDate("create_time"), rs.getDate("update_time")
						);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
