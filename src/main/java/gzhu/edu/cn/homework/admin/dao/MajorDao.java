package gzhu.edu.cn.homework.admin.dao;

import gzhu.edu.cn.homework.admin.entity.Major;
import gzhu.edu.cn.homework.utils.DbUtils;

/**
 * 
 * @author dinggz
 * @date 2019年11月4日 上午12:37:39
 */
public class MajorDao {

	/**
	 * 保存专业
	 * 
	 * @author dinggz
	 * @date 2019年11月4日 上午12:39:26
	 * @param major
	 * @return
	 */
	public boolean saveMajor(Major major) {
		try {
			int majorId = DbUtils.insertReturnKeyId("insert into major(name,description) values('" + major.getName()
					+ "','" + major.getDescription() + "')");
			DbUtils.insert("insert into major_college(major_id,college_id) values(" + majorId + ","
					+ major.getCollege().getId() + ")");
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
