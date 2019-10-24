package gzhu.edu.cn.homework.admin.service;

import java.util.List;

import gzhu.edu.cn.homework.admin.dao.CollegeDao;
import gzhu.edu.cn.homework.admin.entity.College;

public class CollegeService {

	private CollegeDao collegeDao = new CollegeDao();
	
	public List<College> findAll(){
		return collegeDao.findAll();
	} 
	
	
}
