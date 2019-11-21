package gzhu.edu.cn.homework.admin.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import gzhu.edu.cn.homework.admin.dao.KnowledgeObjectDao;
import gzhu.edu.cn.homework.admin.entity.KnowledgeObject;

public class KnowledgeObjectService {

	private KnowledgeObjectDao dao = new KnowledgeObjectDao();
	
	public String getKnowledgeTree(int meta_course_id) throws SQLException {
		List<KnowledgeObject> knowledges = this.dao.getKnowledgeObjectByMetaCourseId(meta_course_id);
		
		StringBuffer buffer = new StringBuffer();
		for (Iterator iterator = knowledges.iterator(); iterator.hasNext();) {
			KnowledgeObject knowledgeObject = (KnowledgeObject) iterator.next();
			//{ id:1, pId:0, name:"父节点1 - 展开", open:true},
			
			Long parentId =null;
			if(knowledgeObject.getParent()!=null) {
				parentId = knowledgeObject.getParent().getId();
			}
			buffer.append("{ id:"+knowledgeObject.getId()+", pId:"+parentId+", name:\""+knowledgeObject.getName()+"\"},");
		}
		buffer.deleteCharAt(buffer.length() - 1);
		return buffer.toString();
		
	}
	
}
