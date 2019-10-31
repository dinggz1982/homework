package gzhu.edu.cn.homework.admin.service;

import java.util.List;

import gzhu.edu.cn.homework.admin.dao.CollegeDao;
import gzhu.edu.cn.homework.admin.entity.College;

public class CollegeService {

	private CollegeDao collegeDao = new CollegeDao();
	
	public List<College> findAll(){
		return collegeDao.findAll();
	} 
	
	public boolean saveCollgeg(College college) {
		return this.collegeDao.saveCollege(college);
	}
	
	public List<College> getCollegeBySchoolId(int schoolId){
		return collegeDao.findCollegeBySchoolId(schoolId);
	} 
	
	
}
