package gzhu.edu.cn.homework.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gzhu.edu.cn.homework.admin.entity.College;
import gzhu.edu.cn.homework.admin.service.CollegeService;

/**
 * Servlet implementation class CollegeServlet
 */
public class CollegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CollegeService collegeService= new CollegeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollegeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<College> colleges = this.collegeService.findAll();
		
		request.setAttribute("colleges", colleges);
		
		request.getRequestDispatcher("admin/college.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
