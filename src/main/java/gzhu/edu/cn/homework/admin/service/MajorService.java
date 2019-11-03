package gzhu.edu.cn.homework.admin.service;
/**
   *  专业服务层代码
 * @author dinggz
 * @date 2019年11月4日 上午12:50:46
 */

import gzhu.edu.cn.homework.admin.dao.MajorDao;
import gzhu.edu.cn.homework.admin.entity.Major;

public class MajorService {
	
	private MajorDao majorDao  = new MajorDao();
	
	/**
	  *  保存专业
	 * @author dinggz
	 * @date 2019年11月4日 上午12:51:44
	 * @param major
	 * @return
	 */
	public boolean saveMajor(Major major) {
		return majorDao.saveMajor(major);
	}

}
