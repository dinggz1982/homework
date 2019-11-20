package gzhu.edu.cn.homework.admin.service;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import gzhu.edu.cn.homework.admin.dao.OutLineDao;
import gzhu.edu.cn.homework.admin.entity.OutLine;

public class OutLineService {
	private OutLineDao outLineDao = new OutLineDao();

	public boolean saveOutLine(OutLine outLine) {
		return outLineDao.saveOutLine(outLine);
	}

	/**
	 * 根据教材id返回大纲列表
	 * 
	 * @author dinggz
	 * @date 2019年11月21日 上午12:41:55
	 * @param textbook_id
	 * @return
	 * @throws SQLException
	 */
	public List<OutLine> getOutLineByTextbookId(long textbook_id) throws SQLException {
		return outLineDao.getOutLineByTextbookId(textbook_id);
	}

	/**
	 * 根据教材id返回ztree树
	 * @author dinggz
	 * @date 2019年11月21日 上午12:52:56
	 * @param textbook_id
	 * @return
	 * @throws SQLException
	 */
	public String getTreeJsonByTextbookId(long textbook_id) throws SQLException {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		List<OutLine> outLines = this.getOutLineByTextbookId(textbook_id);
		if (outLines.size() > 0) {
			for (Iterator iterator = outLines.iterator(); iterator.hasNext();) {
				OutLine outLine = (OutLine) iterator.next();
				// { id:1, pId:0, name:"父节点1 - 展开", open:true},
				Long pId = null;
				if(outLine.getParent()!=null) {
					pId = outLine.getParent().getId();
				}
				//获取是否有子节点信息
				boolean isOpen = this.outLineDao.hasChildren(outLine.getId());
				buffer.append("{ id:"+outLine.getId()+", pId:"+pId+", name:\""+outLine.getName()+"\", open:"+isOpen+"},");
			}
			buffer.deleteCharAt(buffer.length() - 1);
			
		}
		buffer.append("]");
		return buffer.toString();
	}
}
