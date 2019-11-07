package gzhu.edu.cn.homework.admin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gzhu.edu.cn.homework.admin.entity.College;
import gzhu.edu.cn.homework.admin.entity.Major;
import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.utils.DbUtils;
import gzhu.edu.cn.homework.utils.Page;

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
			// 开启事务
			connection.setAutoCommit(false);
			int majorId = DbUtils.insertReturnKeyId("insert into major(name,description) values('" + major.getName()
					+ "','" + major.getDescription() + "')");
			DbUtils.insert("insert into major_college(major_id,college_id) values(" + majorId + ","
					+ major.getCollege().getId() + ")");
			// 提交事务
			connection.commit();
			return true;
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			return false;
		} finally {
			DbUtils.close();
		}

	}
	/**
	 * 学校的分页
	 * 
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page<Major> getPage(int currentPage, int size) {
		Page<Major> page = new Page<>();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// 获取总记录数
		int total = getTotal();
		page.setTotal(total);

		int totalPage = total / size + 1;
		page.setTotalPage(totalPage);

		int begin = (currentPage - 1) * size;
		
		List<Major> majors = new ArrayList<Major>();
		ResultSet resultSet =	DbUtils.find("select s.id as sid,s.name as sname,c.name as cname,c.id as cid,m.name as mname,m.id as mid from major m,school s,college c,major_college mj where s.id=c.school_id and mj.major_id=m.id and c.id = mj.college_id " + begin + "," + size);
		try {
			while (resultSet.next()) {
				try {
					int mid = resultSet.getInt("mid");
					String mname = resultSet.getString("name");
					
					Major major = new Major();
					major.setId(mid);
					major.setName(mname);
					
					
					int sid =  resultSet.getInt("sid");
					String sname =  resultSet.getString("sname");
					School school = new School();
					school.setId(sid);
					school.setName(sname);
					major.setSchool(school);
					
					int cid =  resultSet.getInt("cid");
					String cname =  resultSet.getString("cname");
					
					College college  = new College();
					college.setId(cid);
					college.setName(cname);
					college.setSchool(school);
					
					majors.add(major);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			page.setList(majors);
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
	public int getTotal() {

		ResultSet resultSet = DbUtils.find("select count(*) from major");
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
