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
	 * ����ѧУ��id��ȡѧУ��Ϣ
	 * @param id
	 * @return
	 */
	public School getSchoolById(int id) {
		return dao.getSchoolById(id);
	}

}
