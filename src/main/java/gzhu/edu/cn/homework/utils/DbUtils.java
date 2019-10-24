package gzhu.edu.cn.homework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * ���ݿ����ͨ����
 * 
 * @author Administrator
 */
public class DbUtils {

	static Connection connection = null;

	static Statement statement = null;

	static ResultSet resultSet = null;

	private static String jdbcDriver = null;

	private static String jdbcUrl = null;

	private static String jdbcUsername = null;

	private static String jdbcPassword = null;

	private static String jdbcproperies = "jdbc.properies";

	static {
		Properties properties = new Properties();

		InputStream inputStream = null;
		try {
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(jdbcproperies);
			properties.load(inputStream);

			jdbcDriver = properties.getProperty("jdbc.driver");
			jdbcUrl = properties.getProperty("jdbc.url");
			jdbcUsername = properties.getProperty("jdbc.username");
			jdbcPassword = properties.getProperty("jdbc.password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����connection
	 * 
	 * @return
	 * @Author:Administrator
	 * @Time:����7:16:25
	 */
	public static Connection getConnection() {
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * ����sql��������
	 * 
	 * @return
	 * @Author:Administrator
	 * @Time:����7:17:35
	 */
	public static boolean insert(String sql) {
		boolean result = false;
		try {
			statement = getConnection().createStatement();
			result = statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ����
	 * 
	 * @param sql
	 * @return
	 * @Author:Administrator
	 * @Time:����7:22:07
	 */
	public static boolean update(String sql) {
		boolean result = false;
		try {
			statement = getConnection().createStatement();
			result = statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ɾ��
	 * 
	 * @return
	 * @Author:Administrator
	 * @Time:����7:22:00
	 */
	public static boolean delete(String sql) {
		boolean result = false;
		try {
			statement = getConnection().createStatement();
			result = statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ����
	 * 
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
