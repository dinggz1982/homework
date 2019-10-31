package gzhu.edu.cn.homework.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gzhu.edu.cn.homework.admin.entity.College;
import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.admin.service.CollegeService;
import gzhu.edu.cn.homework.admin.service.SchoolService;

/**
 * Servlet implementation class CollegeServlet
 */
public class CollegeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CollegeService collegeService= new CollegeService();
	
	private SchoolService schoolService = new SchoolService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method.equals("add")) {
			int schoolId = Integer.parseInt(request.getParameter("schoolId"));
			
			List<School> schools = this.schoolService.getAllSchool();
			
			request.setAttribute("schools", schools);
			request.setAttribute("schoolId", schoolId);

			request.getRequestDispatcher("addCollege.jsp").forward(request, response);
		
		}
		if(method.equals("addAction")) {
			int schoolId = Integer.parseInt(request.getParameter("schoolId"));
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			College college = new College();
			college.setAddress(address);
			college.setName(name);
			college.setTel(tel);
			School school = new School();
			school.setId(schoolId);
			college.setSchool(school);
			this.collegeService.saveCollgeg(college);
		}
		if(method.equals("list")) {
			int schoolId = Integer.parseInt(request.getParameter("schoolId"));

			List<College> colleges = this.collegeService.getCollegeBySchoolId(schoolId);
			
			School school = this.schoolService.getSchoolById(schoolId);
			
			request.setAttribute("colleges", colleges);
			request.setAttribute("school", school);

			request.getRequestDispatcher("college.jsp").forward(request, response);
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
