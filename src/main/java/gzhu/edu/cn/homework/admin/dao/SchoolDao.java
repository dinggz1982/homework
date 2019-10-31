package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.utils.DbUtils;

public class SchoolDao {

	/**
	 * 保存学校
	 * 
	 * @param school
	 * @return
	 * @Author:Administrator
	 * @Time:下午7:07:46
	 */
	public boolean saveSchool(School school) {
		boolean success = false;
		success = DbUtils.insert("insert into school(name,address,tel) values ('" + school.getName() + "','"
				+ school.getAddress() + "','" + school.getTel() + "')");
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
	public boolean deleteSchoolById(int schoolId) {
		boolean success = false;
		success = DbUtils.insert("delete from school where id=" + schoolId);
		DbUtils.close();
		return success;
	}

	public boolean updateSchool(School school) {
		boolean success = false;
		success = DbUtils.update("update school set name='" + school.getName() + "',address='" + school.getAddress()
				+ "',tel='" + school.getTel() + "' where id=" + school.getId());
		DbUtils.close();
		return success;
	}

	public List<School> findAll() {
		ResultSet resultSet = DbUtils.find("select * from school order by id desc");

		List<School> schools = new ArrayList<School>();

		try {
			while (resultSet.next()) {
				try {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String address = resultSet.getString("address");
					String tel = resultSet.getString("tel");
					School school = new School();
					school.setId(id);
					school.setAddress(address);
					school.setName(name);
					school.setTel(tel);
					schools.add(school);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schools;
	}
	
	
	public School getSchoolById(int id) {
		ResultSet resultSet = DbUtils.find("select * from school where id="+id);

		School school = null ;
		try {
			while (resultSet.next()) {
				try {
					String name = resultSet.getString("name");
					String address = resultSet.getString("address");
					String tel = resultSet.getString("tel");
					school = new School();
					school.setId(id);
					school.setAddress(address);
					school.setName(name);
					school.setTel(tel);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return school;
	}

}
