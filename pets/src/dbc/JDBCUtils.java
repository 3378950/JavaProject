package dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {

	public static Connection getConnection()
	{
		final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/petstore?serverTimezone=UTC";
		final String DBUSER = "root";
		final String DBPASS = "123456";
		Connection conn=null;
		try
		{
			Class.forName(DBDRIVER);
			conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	public static void close(Connection conn)
	{
		if(conn!=null)
		{
			try
			{
				conn.close();
			} catch(SQLException e)
			{
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
