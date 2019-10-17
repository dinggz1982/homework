package gzhu.edu.cn.homework.admin.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gzhu.edu.cn.homework.admin.dao.SchoolDao;
import gzhu.edu.cn.homework.admin.entity.School;

/**
 * Servlet implementation class SchoolServlet
 */
public class SchoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String method = request.getParameter("method");
		if (method == null || method.length() == 0) {
			// 显示学校列表页面
			SchoolDao dao = new SchoolDao();
			List<School> schools = 	dao.findAll();
			for (Iterator iterator = schools.iterator(); iterator.hasNext();) {
				School school = (School) iterator.next();
				System.out.println(school.getName());
			}
			request.setAttribute("schools", schools);
			
			request.setAttribute("school", "123");
			request.getRequestDispatcher("school.jsp").forward(request, response);
		
		} else if (method.equals("add")) {
			String name = request.getParameter("name");
			String address = request.getParameter("name");
			String tel = request.getParameter("name");
			School school = new School();
			school.setAddress(address);
			school.setName(name);
			school.setTel(tel);
			SchoolDao dao = new SchoolDao();
			dao.saveSchool(school);
			
			response.sendRedirect("../admin/school");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
