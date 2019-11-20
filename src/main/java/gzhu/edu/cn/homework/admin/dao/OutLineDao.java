package gzhu.edu.cn.homework.admin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gzhu.edu.cn.homework.admin.entity.OutLine;
import gzhu.edu.cn.homework.utils.DbUtils;

public class OutLineDao {

	public boolean saveOutLine(OutLine outLine) {
		return DbUtils.insert("insert into outline (name,parent_id,description,textbook_id) Values ('"+outLine.getName()+"',"+outLine.getParent().getId()+",'"+outLine.getDescription()+"',"+outLine.getTextbook().getId()+")");
	}
	
	/**
	 * 获取大纲列表
	 * @author dinggz
	 * @date 2019年11月21日 上午12:40:35
	 * @param textbook_id
	 * @return
	 * @throws SQLException
	 */
	public List<OutLine> getOutLineByTextbookId(long textbook_id) throws SQLException {
		ResultSet resultSet = DbUtils.find("select id,name,parent_id,description from outline where textbook_id="+textbook_id);
		List<OutLine> lines = new ArrayList<OutLine>();
		while (resultSet.next()) {
			OutLine outLine = new OutLine();
			long id =resultSet.getLong("id");
			String name = resultSet.getString("name");
			Long parent_id = resultSet.getLong("parent_id");
			String description = resultSet.getString("description");
			outLine.setId(id);
			outLine.setName(name);
			
			OutLine parent = null;
			if(parent_id != null&&parent_id>0) {
				parent = new OutLine();
				parent.setId(parent_id);
			}
			outLine.setParent(parent);
			outLine.setDescription(description);
			lines.add(outLine);
		}
		return lines;
	}
	/**
	 * 判断当前id下是否有子节点
	 * @author dinggz
	 * @date 2019年11月21日 上午12:50:03
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public boolean hasChildren(long id) throws SQLException {
		ResultSet resultSet = DbUtils.find("select id from outline where parent_id="+id);
		if(resultSet.next()) {
			return true;
		}else {
			return false;
		}

	}
	
}
