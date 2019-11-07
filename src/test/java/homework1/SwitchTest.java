package homework1;

import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.admin.service.SchoolService;

public class SwitchTest {

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			SchoolService schoolService = new SchoolService();
			School school = new School("测试学校" + i,"测试地址"+i,"测试电话"+i);
			schoolService.saveSchool(school);
			
		}
		
		

	}
}
