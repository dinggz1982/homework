package gzhu.edu.cn.homework.admin.service;

import gzhu.edu.cn.homework.admin.dao.UserDao;
import gzhu.edu.cn.homework.admin.entity.User;

/**
 * 用户服务层代码
 * @author dinggz
 *
 */
public class UserService {
	
	public User getUserByUsernameAndPassword(String username, String password) {
		UserDao dao = new UserDao();
		return dao.getUserByUsernameAndPassword(username, password);
	}

}
