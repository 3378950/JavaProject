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

public class DBUtils {
	public static <E> List<E> findAll(Class c) {
		Table table = (Table)c.getDeclaredAnnotation(Table.class);
		String tableName = "";		
		if(table == null) {
			tableName = c.getSimpleName();
		} else {
			tableName = table.value();
		}
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
	};
}
