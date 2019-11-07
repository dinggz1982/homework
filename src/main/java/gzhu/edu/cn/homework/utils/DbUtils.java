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
 * JDBC工具类
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

	//初始化数据库连接
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
	 * 创建connection
	 * @return
	 * @Author:Administrator
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
	 *  根据sql插入数据
	 * @author dinggz
	 * @date 2019年11月4日 上午12:42:40
	 * @param sql
	 * @return
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
	 * 根据sql插入数据，并返回插入数据对应的主键的值
	 * @author dinggz
	 * @date 2019年11月4日 上午12:46:41
	 * @param sql
	 * @return
	 */
	public static int insertReturnKeyId(String sql) {
		int id=0;
		try {
			statement = getConnection().createStatement();
			statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
			ResultSet resultSet = 	statement.getGeneratedKeys();
			if (resultSet.next())
				id = resultSet.getInt(1);//Id在结果集中的第一位
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 根据sql更新
	 * @param sql
	 * @return
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
	 * 根据sql删除数据
	 * @param sql
	 * @return
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
	 * 查询
	 * @param sql
	 * @return
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

	/**
	 * 关闭数据库连接
	 */
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
