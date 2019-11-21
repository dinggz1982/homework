package gzhu.edu.cn.homework.knowledge;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hpsf.Date;

import gzhu.edu.cn.homework.admin.service.KnowledgeObjectService;

public class KnowledgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private KnowledgeObjectService service = new KnowledgeObjectService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(new java.util.Date() + "===");
		
		try {
			String tree = service.getKnowledgeTree(1);
			request.setAttribute("tree", tree);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("knowledge/index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
