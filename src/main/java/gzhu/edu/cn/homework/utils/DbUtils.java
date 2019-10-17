package gzhu.edu.cn.homework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ����ͨ����
 * 
 * @author Administrator
 */
public class DbUtils {
	
	
	static Connection connection = null;
	
	static Statement statement = null;
	
	static ResultSet resultSet = null;
	
	/**
	 *  ����connection
	 * @return
	 * @Author:Administrator
	 * @Time:����7:16:25
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/jyjs181?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC", "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * ����sql��������
	 * @return
	 * @Author:Administrator
	 * @Time:����7:17:35
	 */
	public static boolean insert(String sql) {
		boolean result=false;
		try {
			statement = getConnection().createStatement();
			result =  statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ����
	 * @param sql
	 * @return
	 * @Author:Administrator
	 * @Time:����7:22:07
	 */
	public static boolean update(String sql) {
		boolean result=false;
		try {
			statement = getConnection().createStatement();
			result =  statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ɾ��
	 * @return
	 * @Author:Administrator
	 * @Time:����7:22:00
	 */
	public static boolean delete(String sql) {
		boolean result=false;
		try {
			statement = getConnection().createStatement();
			result =  statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * ����
	 * @param sql
	 * @return
	 * @Author:Administrator
	 * @Time:����7:22:51
	 */
	public static ResultSet find(String sql) {
		try {
			statement = getConnection().createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	public static void close() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
}
