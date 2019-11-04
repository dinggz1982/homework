package gzhu.edu.cn.homework.admin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import gzhu.edu.cn.homework.admin.entity.Major;
import gzhu.edu.cn.homework.utils.DbUtils;

/**
 * 
 * @author dinggz
 * @date 2019年11月4日 上午12:37:39
 */
public class MajorDao {
	/**
	 * 保存专业
	 * 
	 * @author dinggz
	 * @date 2019年11月4日 上午12:39:26
	 * @param major
	 * @return
	 */
	public boolean saveMajor(Major major) {
		Connection connection = null;
		try {
			 connection = DbUtils.getConnection();
			//开启事务
			connection.setAutoCommit(false);
			int majorId = DbUtils.insertReturnKeyId("insert into major(name,description) values('" + major.getName()
					+ "','" + major.getDescription() + "')");
			DbUtils.insert("insert into major_college(major_id,college_id) values(" + majorId + ","
					+ major.getCollege().getId() + ")");
			//提交事务
			connection.commit();
			return true;
		} catch (Exception e) {
			if(connection!=null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return false;
		}finally {
			DbUtils.close();
		}

	}

}
