package utils;
// use the reflect, you can query for the different table with this template
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.coach;
import entity.player;
import entity.team;



public class DBUtils {
	// query for the whole table
	public static <E> List<E> findAll(Class c) {
		// access the name of table
		
		String tableName = c.getSimpleName();		
		
		// make up the sql
		String sql = "select * from " + tableName + ";";
		System.out.println(sql);
		// connection procession
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<E> list = new ArrayList();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?useUnicode=true&characterEncoding=utf8", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			Field[] fields = c.getDeclaredFields();
			while(rs.next()) {
				E e = (E)c.newInstance();
				
				for (Field field : fields) {
					String columnName = field.getName();
//					System.out.println(columnName);
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
			// close all
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
	// fulfill the information for the team: player information
	public static List<player> findByTeam(String teamName) {
		String sql = "select * from player where teamName = " + "'" + teamName + "'";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<player> list = new ArrayList<player>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?useUnicode=true&characterEncoding=utf8", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while(rs.next()) {
				player e = new player();
				e.setAddress(rs.getString("address"));
				e.setBirthDate(rs.getDate("birthDate"));
				e.setHeight(rs.getInt("height"));
				e.setName(rs.getString("name"));
				e.setPersonId(rs.getString("personId"));
				e.setTeamName(rs.getString("teamName"));
				
				list.add(e);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
	// fulfill the information for the team: coach information 
	public static List<coach> findCoach(String teamName) {
		String sql = "select * from coach where teamName = " + "'" + teamName + "';";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<coach> res = new ArrayList<coach>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?useUnicode=true&characterEncoding=utf8", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while(rs.next()) {
				coach e = new coach();
				e.setBirthDate(rs.getDate("birthDate"));
				e.setCertificate(rs.getString("certificate"));
				e.setLevel(rs.getString("level"));
				e.setName(rs.getString("name"));
				e.setPersonId(rs.getString("personId"));
				
				e.setTeamName(rs.getString("teamName"));
				res.add(e);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
		return res;
	}
	// the primary key for player
	public static List<player> findByPersonId(String personId) {
		String sql = "select * from player where personId = " + "'" + personId + "';";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<player> list = new ArrayList<player>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?uesSSL=false", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while(rs.next()) {

				player e = new player();
				e.setAddress(rs.getString("address"));
				e.setBirthDate(rs.getDate("birthDate"));
				e.setHeight(rs.getInt("height"));
				e.setName(rs.getString("name"));
				e.setPersonId(rs.getString("personId"));
				e.setTeamName(rs.getString("teamName"));
				
				list.add(e);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
	// the primary key for team
	public static List<team> findByTeamId(String teamId) {
		String sql = "select * from team where id = " + "'" + teamId + "';";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<team> list = new ArrayList<team>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?uesSSL=false", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while(rs.next()) {

				team e = new team();
				e.setSetUp(rs.getDate("setUp"));
				e.setAddress(rs.getString("address"));
				e.setId(rs.getString("id"));
				e.setPeopleCounting(rs.getInt("peopleCounting"));
				e.setTeamName(rs.getString("teamName"));
				list.add(e);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
	// the primary key for coach
	public static List<coach> findByCoachId(String id) {
		String sql = "select * from coach where personId = '" + id + "';";
		System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement psta = null;
		ResultSet rs = null;
		List<coach> list = new ArrayList<coach>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?uesSSL=false", "root", "root");
			psta = conn.prepareStatement(sql);
			rs = psta.executeQuery();
			while(rs.next()) {

				coach e = new coach();
				e.setBirthDate(rs.getDate("birthDate"));
				e.setCertificate(rs.getString("certificate"));
				e.setLevel(rs.getString("level"));
				e.setName(rs.getString("name"));
				e.setPersonId(rs.getString("personId"));
				e.setTeamName(rs.getString("teamName"));
				list.add(e);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
	// insert 
	public static void save(Object o) {
		String tableName = o.getClass().getSimpleName();
//		System.out.println(tableName);
		String sql = null;
		String className = o.getClass().getSimpleName();
		System.out.println(className);
		if("coach".equals(className)) sql = "insert into " + tableName + " " + ((coach) o).values();
		else if("team".equals(className)) sql = "insert into " + tableName +  ((team) o).values();
		else if("player".equals(className)) sql = "insert into " + tableName + ((player) o).values();
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?useUnicode=true&characterEncoding=utf8", "root", "root");
			psta = conn.prepareStatement(sql);
			psta.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
			
		}
		System.out.println("Successed");
	}
	// delete 
	public static void delete(Object o, String columnName, Object key) {
		String tableName = o.getClass().getSimpleName();
		String sql = null;
		if("String".equals(key.getClass().getSimpleName()) || "Date".equals(key.getClass().getSimpleName()))
			sql = "delete from " + tableName + " where " + columnName + "='" + key + "';";
		else sql = "delete from " + tableName + " where " + columnName + "=" + key + ";";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?useUnicode=true&characterEncoding=utf8", "root", "root");
			psta = conn.prepareStatement(sql);
			psta.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
			
		}
		System.out.println("Successed");
	}
	// update
	public static void update(Object o, String columnName, Object key) {
		String  tableName = o.getClass().getSimpleName();
		String sql = "";
		if("String".equals(key.getClass().getSimpleName()) || "Date".equals(key.getClass().getSimpleName()))
			sql = "update " + tableName + " set " + columnName + "='" + key + "';";
		else sql = "update " + tableName + " set " + columnName + "=" + key + ";";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement psta = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/soccer?useUnicode=true&characterEncoding=utf8", "root", "root");
			psta = conn.prepareStatement(sql);
			psta.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close all
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
			
		}
		System.out.println("Successed");
	}
}
