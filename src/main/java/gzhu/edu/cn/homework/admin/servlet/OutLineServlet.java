package gzhu.edu.cn.homework.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gzhu.edu.cn.homework.admin.service.OutLineService;

/**
 * Servlet implementation class OutLineServlet
 */
public class OutLineServlet extends HttpServlet {
	private OutLineService lineService = new OutLineService();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OutLineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决json中文乱码
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
		String method = request.getParameter("tree");
		
		if(method==null) {
			try {
				String tree = this.lineService.getTreeJsonByTextbookId(1l);
				request.setAttribute("tree", tree);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("outline.jsp").forward(request, response);
		}else {
			switch (method) {
			case "tree":
				PrintWriter out = response.getWriter();
				
				String textBookId = request.getParameter("textBookId");
				
				long textBook_id = Long.parseLong(textBookId);
				String tree;
				try {
					tree = this.lineService.getTreeJsonByTextbookId(textBook_id);
					 out.println(tree);
				     out.flush();
				     out.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				break;

			default:
				break;
			}
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
