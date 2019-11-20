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
			/*
			 * connection = DbUtils.getConnection(); // 开启事务
			 * connection.setAutoCommit(false);
			 */
			return DbUtils.insert("insert into major(name,description,college_id) values('" + major.getName()
					+ "','" + major.getDescription() + "',"+major.getCollege().getId()+")");
			
			// 提交事务
			//connection.commit();
		} catch (Exception e) {
			return false;
		} finally {
			DbUtils.close();
		}

	}
	
	/**
	 * 通过专业名和学院id查询专业
	 * @author dinggz
	 * @date 2019年11月20日 下午11:39:15
	 * @param name
	 * @param college_id
	 * @return
	 * @throws SQLException 
	 */
	public Major getMajorByNameAndCollegeId(String name,int college_id) throws SQLException {
		ResultSet resultSet =	DbUtils.find("select s.id as sid,s.name as sname,c.name as cname,c.id as cid,m.name as mname,m.id as mid from major m,school s,college c where s.id=c.school_id   and c.id = m.college_id and c.id="+college_id + " and m.name='"+name+"'");
		Major major = null;
		while (resultSet.next()) {
				try {
					int mid = resultSet.getInt("mid");
					String mname = resultSet.getString("name");
					
					major = new Major();
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
					
					major.setCollege(college);
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return major;
	}
	
	/**
	 * 专业的分页
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
		ResultSet resultSet =	DbUtils.find("select s.id as sid,s.name as sname,c.name as cname,c.id as cid,m.name as mname,m.id as mid from major m,school s,college c where s.id=c.school_id   and c.id = m.college_id " + begin + "," + size);
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
