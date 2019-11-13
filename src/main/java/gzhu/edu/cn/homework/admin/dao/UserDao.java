package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gzhu.edu.cn.homework.admin.entity.User;
import gzhu.edu.cn.homework.utils.DbUtils;
import gzhu.edu.cn.homework.utils.Page;

public class UserDao {
	/**
	 * 保存用户
	 * @return
	 */
	public boolean saveUser(User user) {
		return DbUtils.insert("insert into users(username,password,gender,realname,description,type) values '"+user.getUsername()+"','"+user.getPassword()+"','"+user.getGender()+"','"+user.getRealname()+"','"+user.getDescription()+"',"+user.getType()+"");
	}

	/**
	 * 根据用户名和密码查询用户
	 * @author dinggz
	 * @date 2019年11月13日 下午9:24:15
	 * @param username
	 * @param password
	 * @return
	 */
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
	/**
	  *  用户分页
	 * @author dinggz
	 * @date 2019年11月13日 下午9:32:49
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page<User> getPage(int currentPage, int size,String sql) {
		Page<User> page = new Page<>();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// 获取总记录数
		int total = getTotal(sql);
		page.setTotal(total);

		int totalPage = total / size + 1;
		page.setTotalPage(totalPage);

		int begin = (currentPage - 1) * size;
		
		List<User> users = new ArrayList<User>();
		
		String pageSql = null;
		if(sql==null||sql.length()==0) {
			pageSql ="select id,username,realname,gender,description,type from users  limit " + begin + "," + size;
		}else{
			pageSql ="select id,username,realname,gender,description,type from users where "+ sql +" limit " + begin + "," + size;
		}
		
		ResultSet resultSet =	DbUtils.find(pageSql);
		try {
			while (resultSet.next()) {
				try {
					int id = resultSet.getInt("id");
					String username = resultSet.getString("username");
					String realname = resultSet.getString("realname");
					String gender = resultSet.getString("gender");
					String description = resultSet.getString("description");
					int type = resultSet.getInt("type");
					User user = new User();
					user.setId(id);
					user.setUsername(username);
					user.setRealname(realname);
					user.setGender(gender);
					user.setDescription(description);
					user.setType(type);
					users.add(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			page.setList(users);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	
	
	/**
	 * 获取总记录数
	 * 
	 * @return
	 */
	public int getTotal(String sql) {
		ResultSet resultSet =null;
		if(sql==null||sql.length()==0) {
			 resultSet = DbUtils.find("select count(*) from users");
		}else {
			resultSet = DbUtils.find("select count(*) from users where "+sql);
		}
		try {
			if (resultSet.next()) {
				return resultSet.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
