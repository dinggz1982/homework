package gzhu.edu.cn.homework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import gzhu.edu.cn.homework.admin.entity.ClassInfo;
import gzhu.edu.cn.homework.admin.entity.College;
import gzhu.edu.cn.homework.admin.entity.Major;
import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.admin.entity.User;
/**
 * 处理用户上传
 * @author dinggz
 * @date 2019年11月17日 下午10:06:10
 */
public class ParseUserFile {
	
	public static void getUsers(File files) {
		
		
		
		
	}
	
	/**
	 * 读取xls文档
	 * @author dinggz
	 * @date 2019年11月17日 下午10:08:01
	 * @param path
	 * @throws Exception
	 */
	 public static List<User> readUserFormFile(File file,int school_id) throws Exception {
	        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
	        HSSFSheet sheet = null;
	        List<User> users = new ArrayList<User>();
	        //获取第一张表
	            sheet = workbook.getSheetAt(0);
	            School school = new School();
	            school.setId(school_id);
	            for (int i= 0; i< sheet.getLastRowNum() + 1; i++) {// getLastRowNum，获取最后一行的行标
	                HSSFRow row = sheet.getRow(i);
	                if (row != null) {
	                	//学院名字
	                	String collegeName = row.getCell(0).getStringCellValue();
	                	String majorName = row.getCell(1).getStringCellValue();
	                	String grade = row.getCell(2).getStringCellValue();
	                	String className = row.getCell(3).getStringCellValue();
	                	String role =  row.getCell(4).getStringCellValue();
	                	String userName = row.getCell(5).getStringCellValue();
	                	String realName = row.getCell(6).getStringCellValue();
	                	String gender = row.getCell(7).getStringCellValue();

	                	
	                	College college = new College();
	                	college.setName(collegeName);
	                	college.setSchool(school);
	                	
	                	Major major = new Major();
	                	major.setName(majorName);
	                	major.setCollege(college);
	                	
	                	ClassInfo classInfo = new ClassInfo();
	                	classInfo.setMajor(major);
	                	classInfo.setName(className);
	                	classInfo.setGrade(grade);
	                	
	                	User user = new User();
	                	user.setGender(gender);
	                	user.setRealname(realName);
	                	user.setUsername(userName);
	                	user.setClassInfo(classInfo);
	                	user.setCollege(college);
	                	user.setMajor(major);
	                	int type = 0;
	                	switch (role) {
						case "管理员":
							type = 1;
							break;
						case "教师":
							type = 2;
							break;
						case "学生":
							type = 3;
							break;
						default:
							type =4;
							break;
						}
	                	user.setType(type);
	                	users.add(user);
	                }
	            }
	            workbook.close();
	        return users;
	    }

}
