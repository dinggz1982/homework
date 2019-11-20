package gzhu.edu.cn.homework.admin.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import gzhu.edu.cn.homework.admin.dao.ClassInfoDao;
import gzhu.edu.cn.homework.admin.dao.CollegeDao;
import gzhu.edu.cn.homework.admin.dao.MajorDao;
import gzhu.edu.cn.homework.admin.dao.SchoolDao;
import gzhu.edu.cn.homework.admin.dao.UserDao;
import gzhu.edu.cn.homework.admin.entity.ClassInfo;
import gzhu.edu.cn.homework.admin.entity.College;
import gzhu.edu.cn.homework.admin.entity.Major;
import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.admin.entity.User;
import gzhu.edu.cn.homework.utils.Page;
import gzhu.edu.cn.homework.utils.ParseUserFile;

/**
 * 用户操作
 * @author dinggz
 *
 */
public class UserService {
	private UserDao dao = new UserDao();
	private SchoolDao schoolDao  = new SchoolDao();
	private CollegeDao collegeDao  = new CollegeDao();
	private MajorDao majorDao = new MajorDao();
	private ClassInfoDao classInfoDao = new ClassInfoDao();
	
	public User getUserByUsernameAndPassword(String username, String password) {
		return this.dao.getUserByUsernameAndPassword(username, password);
	}
	
	public Page<User> getPage(int currentPage, int size,String sql){
		return this.dao.getPage(currentPage, size, sql);
	}
	
	public int getTotal(String sql) {
		return this.getTotal(sql);
	}
	
	/**
	   * 从附件中保存用户信息
	 * @author dinggz
	 * @date 2019年11月20日 下午10:24:27
	 * @param file
	 * @param school_id
	 * @return
	 * @throws Exception 
	 */
	public boolean saveUserFormFile(File file,int school_id) throws Exception {
		List<User> users = ParseUserFile.readUserFormFile(file, school_id);
		School school = new School();
		school.setId(school_id);
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			
			//获取学院
			College college = this.collegeDao.findCollegeByNameAndSchoolId(user.getCollege().getName(), school_id);
			if(college ==null) {
				college  = new College();
				
				college.setSchool(school);
				college.setName(user.getCollege().getName());
				this.collegeDao.saveCollege(college);
			}
			//获取专业
			Major major = this.majorDao.getMajorByNameAndCollegeId(user.getMajor().getName(),college.getId());
			if(major==null) {
				major = new Major();
				major.setCollege(college);
				major.setName(user.getMajor().getName());
				major.setSchool(school);
				this.majorDao.saveMajor(major);
			}
			//获取班级
			ClassInfo classInfo = this.classInfoDao.getClassInfoByNameAndMajorId(user.getClassInfo().getName(), major.getId());
			if(classInfo==null) {
				classInfo = new ClassInfo();
				classInfo.setGrade(user.getClassInfo().getGrade());
				classInfo.setMajor(major);
				classInfo.setName(user.getClassInfo().getName());
				this.classInfoDao.saveClass(classInfo);
			}
			this.dao.saveUser(user);
		}
		
		
		return false;
	}
}
