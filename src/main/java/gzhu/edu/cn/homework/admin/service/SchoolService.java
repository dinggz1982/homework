package gzhu.edu.cn.homework.admin.service;

import java.util.List;

import gzhu.edu.cn.homework.admin.dao.SchoolDao;
import gzhu.edu.cn.homework.admin.entity.School;

public class SchoolService {

	private SchoolDao dao = new SchoolDao();

	/**
	 * 取得全部学校数据
	 * @return
	 */
	public List<School> getAllSchool() {
		return dao.findAll();
	}

	/**
	 * 根据学校id获取学校信息
	 * @param id
	 * @return
	 */
	public School getSchoolById(int id) {
		return dao.getSchoolById(id);
	}

	/**
	 * 保存学校
	 * @param school
	 * @return
	 */
	public boolean saveSchool(School school) {
		return dao.saveSchool(school);
	}
	
	/**
	 * 更新保存学校
	 * @param school
	 * @return
	 */
	public boolean updateSchool(School school) {
		return dao.updateSchool(school);
	}
}
