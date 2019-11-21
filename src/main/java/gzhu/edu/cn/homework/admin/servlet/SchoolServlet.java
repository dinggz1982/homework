package gzhu.edu.cn.homework.admin.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.admin.service.SchoolService;
import gzhu.edu.cn.homework.utils.Page;

/**
 * Servlet implementation class SchoolServlet
 */
public class SchoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SchoolService schoolService = new SchoolService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String method = request.getParameter("method");
		if (method == null || method.length() == 0) {
			// 显示学校列表
			
			String currentPageStr = request.getParameter("currentPage");
			int currentPage;
			if(currentPageStr==null) {
				currentPage= 1;
			}else {
				currentPage = Integer.parseInt(currentPageStr);
			}
			
			String sizeStr = request.getParameter("size");
			int size;
			if(sizeStr==null) {
				size= 10;
			}else {
				size = Integer.parseInt(sizeStr);
			}
			
			Page<School> page = this.schoolService.getPage(currentPage, size);
			request.setAttribute("page", page);
			request.getRequestDispatcher("school.jsp").forward(request, response);
		
		} else if (method.equals("add")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			School school = new School();
			school.setAddress(address);
			school.setName(name);
			school.setTel(tel);
			String schoolId = request.getParameter("id");
			if(schoolId==null||schoolId.equals("")) {
				schoolService.saveSchool(school);
			}else {
				int id = Integer.parseInt(schoolId);
				school.setId(id);
				this.schoolService.updateSchool(school);
			}
			
			request.getRequestDispatcher("addSuccess.jsp").forward(request, response);
		}
		else if (method.equals("edit")) {
			//修改学校
			int schoolId = Integer.parseInt(request.getParameter("schoolId"));
			School school = this.schoolService.getSchoolById(schoolId);
			request.setAttribute("school",school);
			request.getRequestDispatcher("addSchool.jsp").forward(request, response);
		}
		else if (method.equals("delete")) {
			//删除学校
			int schoolId = Integer.parseInt(request.getParameter("schoolId"));
			this.schoolService.deleteSchoolById(schoolId);
			response.sendRedirect("school");
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
