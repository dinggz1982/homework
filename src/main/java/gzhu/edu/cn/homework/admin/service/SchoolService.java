package gzhu.edu.cn.homework.admin.service;

import java.util.List;

import gzhu.edu.cn.homework.admin.dao.SchoolDao;
import gzhu.edu.cn.homework.admin.entity.School;

public class SchoolService {

	private SchoolDao dao = new SchoolDao();

	public List<School> getAllSchool() {
		return dao.findAll();
	}

	/**
	 * 根据学校的id获取学校信息
	 * @param id
	 * @return
	 */
	public School getSchoolById(int id) {
		return dao.getSchoolById(id);
	}

}
