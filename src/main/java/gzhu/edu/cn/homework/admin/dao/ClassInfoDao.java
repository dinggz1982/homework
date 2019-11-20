package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gzhu.edu.cn.homework.admin.entity.ClassInfo;
import gzhu.edu.cn.homework.admin.entity.Major;
import gzhu.edu.cn.homework.utils.DbUtils;

public class ClassInfoDao {

	/**
	 * 保存班级
	 * 
	 * @param classInfo
	 * @return
	 * @Author:Administrator
	 */
	public boolean saveClass(ClassInfo classInfo) {
		boolean success = false;
		success = DbUtils.insert("insert into class_info(name,major_id,grade) values ('" + classInfo.getName() + "',"
				+ classInfo.getMajor().getId() + ",'" + classInfo.getGrade() + "')");
		DbUtils.close();
		return success;

	}

	/**
	 * 删除班级
	 * 
	 * @param id
	 * @return
	 * @Author:Administrator
	 */
	public boolean deleteSchoolById(int id) {
		boolean success = false;
		success = DbUtils.insert("delete from class_info where id=" + id);
		DbUtils.close();
		return success;
	}


	public List<ClassInfo> findAll() {
		ResultSet resultSet = DbUtils.find("select * from class_info order by id desc");

		List<ClassInfo> classInfos = new ArrayList<ClassInfo>();

		try {
			while (resultSet.next()) {
				try {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String grade= resultSet.getString("grade");
					ClassInfo classInfo = new ClassInfo();
					classInfo.setName(name);
					classInfo.setGrade(grade);
					classInfos.add(classInfo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classInfos;
	}

	/**
	 * 根据专业id获取相关信息
	 * @author dinggz
	 * @date 2019年11月20日 下午11:48:37
	 * @param id
	 * @return
	 */
	public ClassInfo getClassInfoById(int id) {
		ResultSet resultSet = DbUtils.find("select c.id as cid,c.name as cname,c.grade as cgrade,c.major_id as cmajor_id,m.name as mname,m.id as mname from class_info,major where c.id=" + id + " and m.id=c.major_id");

		ClassInfo classInfo = null;
		try {
			while (resultSet.next()) {
				try {
					String name = resultSet.getString("name");
					String grade= resultSet.getString("grade");
					classInfo = new ClassInfo();
					classInfo.setName(name);
					classInfo.setId(id);
					classInfo.setGrade(grade);
					Major major = new Major();
					int mid = resultSet.getInt("mid");
					major.setId(mid);
					String mname = resultSet.getString("mname");
					major.setName(mname);
					classInfo.setMajor(major);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classInfo;
	}
	
	/**
	 * 根据专业id获取相关信息
	 * @author dinggz
	 * @date 2019年11月20日 下午11:48:37
	 * @param id
	 * @return
	 */
	public ClassInfo getClassInfoByNameAndMajorId(String name, int major_id) {
		ResultSet resultSet = DbUtils.find("select c.id as cid,c.name as cname,c.grade as cgrade,c.major_id as cmajor_id,m.name as mname,m.id as mname from class_info c,major m where  and m.id="+major_id+" and c.name='"+name+"'");

		ClassInfo classInfo = null;
		try {
			while (resultSet.next()) {
				try {
					String grade= resultSet.getString("grade");
					classInfo = new ClassInfo();
					classInfo.setName(name);
					int cid = resultSet.getInt("cid");
					classInfo.setId(cid);
					classInfo.setGrade(grade);
					Major major = new Major();
					
					major.setId(major_id);
					String mname = resultSet.getString("mname");
					major.setName(mname);
					classInfo.setMajor(major);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classInfo;
	}
}
