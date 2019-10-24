package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import gzhu.edu.cn.homework.admin.entity.User;
import gzhu.edu.cn.homework.utils.DbUtils;

public class UserDao {
	/**
	 * ±£¥Ê”√ªß
	 * 
	 * @return
	 */
	public boolean saveUser() {
		return false;
	}

	public User getUserByUsernameAndPassword(String username, String password) {
		ResultSet resultSet = DbUtils.find("select id,username,gender,description,realname from users where username='" + username
				+ "' and password='" + password + "'");
	
		try {
			if(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setGender(resultSet.getString("gender"));
				user.setDescription(resultSet.getString("description"));
				user.setRealname(resultSet.getString("realname"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
