package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.utils.DbUtils;
import gzhu.edu.cn.homework.utils.Page;

public class SchoolDao {

	/**
	 * 保存学习
	 * 
	 * @param school
	 * @return
	 * @Author:Administrator
	 */
	public boolean saveSchool(School school) {
		boolean success = false;
		success = DbUtils.insert("insert into school(name,address,tel) values ('" + school.getName() + "','"
				+ school.getAddress() + "','" + school.getTel() + "')");
		DbUtils.close();
		return success;

	}

	/**
	 * 删除学习
	 * 
	 * @param schoolId
	 * @return
	 * @Author:Administrator
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
		ResultSet resultSet = DbUtils.find("select * from school where id=" + id);

		School school = null;
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

	/**
	 * 学校的分页
	 * 
	 * @param currentPage
	 * @param size
	 * @return
	 */
	public Page<School> getPage(int currentPage, int size) {
		Page<School> page = new Page<>();
		page.setCurrentPage(currentPage);
		page.setSize(size);
		// 获取总记录数
		int total = getTotal();
		page.setTotal(total);

		int totalPage = total / size + 1;
		page.setTotalPage(totalPage);

		int begin = (currentPage - 1) * size;
		
		List<School> schools = new ArrayList<School>();
		ResultSet resultSet =	DbUtils.find("select id,name,address,tel from school limit " + begin + "," + size);
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
			page.setList(schools);
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

		ResultSet resultSet = DbUtils.find("select count(*) from school");
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
