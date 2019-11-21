package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import gzhu.edu.cn.homework.admin.entity.KnowledgeObject;
import gzhu.edu.cn.homework.utils.DbUtils;

public class KnowledgeObjectDao {

	
	/**
	 * 根据课元id获取到全部知识体系
	 * @param meta_course_id
	 * @return
	 * @throws SQLException
	 */
	public List<KnowledgeObject> getKnowledgeObjectByMetaCourseId(int meta_course_id) throws SQLException {

		ResultSet resultSet = DbUtils.find("select id,name,parent_id from knowledge_object where meta_course_id=" + meta_course_id);
		
		List<KnowledgeObject> knowledgeObjects = new ArrayList<>();
		
		while(resultSet.next()) {
			
			KnowledgeObject knowledgeObject = new KnowledgeObject();
			
			long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			Long parent_id = resultSet.getLong("parent_id");
			knowledgeObject.setId(id);
			knowledgeObject.setName(name);
			KnowledgeObject parent = null;
			if(parent_id==null||parent_id.toString().equals("")) {
				knowledgeObject.setParent(null);
			}else {
				parent = new KnowledgeObject();
				parent.setId(parent_id);
				knowledgeObject.setParent(parent);
			}
			knowledgeObjects.add(knowledgeObject);
		}
		
		return knowledgeObjects;
	}

}
