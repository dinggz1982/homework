package gzhu.edu.cn.homework.admin.service;

import gzhu.edu.cn.homework.admin.dao.UserDao;
import gzhu.edu.cn.homework.admin.entity.User;
import gzhu.edu.cn.homework.utils.Page;

/**
 * 用户操作
 * @author dinggz
 *
 */
public class UserService {
	private UserDao dao = new UserDao();
	public User getUserByUsernameAndPassword(String username, String password) {
		return this.dao.getUserByUsernameAndPassword(username, password);
	}
	
	public Page<User> getPage(int currentPage, int size,String sql){
		return this.dao.getPage(currentPage, size, sql);
	}
	
	public int getTotal(String sql) {
		return this.getTotal(sql);
	}
}
