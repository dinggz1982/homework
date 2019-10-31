package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gzhu.edu.cn.homework.admin.entity.College;
import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.utils.DbUtils;

public class CollegeDao {

	/**
	 * 保存学院
	 * 
	 * @param school
	 * @return
	 * @Author:Administrator
	 * @Time:下午7:07:46
	 */
	public boolean saveCollege(College college) {
		boolean success = false;
		success = DbUtils.insert("insert into college(name,address,tel,school_id) values ('" + college.getName() + "','"
				+ college.getAddress() + "','" + college.getTel() + "'," + college.getSchool().getId() + ")");
		DbUtils.close();
		return success;

	}

	/**
	 * 删除学校
	 * 
	 * @param schoolId
	 * @return
	 * @Author:Administrator
	 * @Time:下午7:10:21
	 */
	public boolean deleteCollegeById(int collegeId) {
		boolean success = false;
		success = DbUtils.insert("delete from college where id=" + collegeId);
		DbUtils.close();
		return success;
	}

	public boolean updateCollege(College college) {
		boolean success = false;
		success = DbUtils.update("update college set name='" + college.getName() + "',address='" + college.getAddress()
				+ "',tel='" + college.getTel() + "',school_id=" + college.getSchool().getId() + " where id="
				+ college.getId());
		DbUtils.close();
		return success;
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<College> findAll() {
		ResultSet resultSet = DbUtils.find(
				"select s.id as sid,s.name as sname,s.address as saddress,s.tel as stel,c.id as cid,c.name as cname,c.address as caddress,c.tel as ctel from school s,college c where  s.id=c.school_id");

		List<College> colleges = new ArrayList<College>();

		try {
			while (resultSet.next()) {
				try {
					int sid = resultSet.getInt("sid");
					String sname = resultSet.getString("sname");
					String saddress = resultSet.getString("saddress");
					String stel = resultSet.getString("stel");
					School school = new School();
					school.setId(sid);
					school.setAddress(saddress);
					school.setName(sname);
					school.setTel(stel);
					
					College college = new College();
					int cid = resultSet.getInt("cid");
					String cname = resultSet.getString("cname");
					String caddress = resultSet.getString("caddress");
					String ctel = resultSet.getString("ctel");
					college.setAddress(caddress);
					college.setId(cid);
					college.setName(cname);
					college.setSchool(school);
					college.setTel(ctel);
					colleges.add(college);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colleges;
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<College> findCollegeBySchoolId(int schoolId) {
		ResultSet resultSet = DbUtils.find(
				"select s.id as sid,s.name as sname,s.address as saddress,s.tel as stel,c.id as cid,c.name as cname,c.address as caddress,c.tel as ctel from school s,college c where  s.id=c.school_id and s.id="+schoolId);
		List<College> colleges = new ArrayList<College>();
		try {
			while (resultSet.next()) {
				try {
					int sid = resultSet.getInt("sid");
					String sname = resultSet.getString("sname");
					String saddress = resultSet.getString("saddress");
					String stel = resultSet.getString("stel");
					School school = new School();
					school.setId(sid);
					school.setAddress(saddress);
					school.setName(sname);
					school.setTel(stel);
					
					College college = new College();
					int cid = resultSet.getInt("cid");
					String cname = resultSet.getString("cname");
					String caddress = resultSet.getString("caddress");
					String ctel = resultSet.getString("ctel");
					college.setAddress(caddress);
					college.setId(cid);
					college.setName(cname);
					college.setSchool(school);
					college.setTel(ctel);
					colleges.add(college);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return colleges;
	}
}
