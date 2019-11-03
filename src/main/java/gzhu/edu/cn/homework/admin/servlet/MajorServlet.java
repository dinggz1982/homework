package gzhu.edu.cn.homework.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gzhu.edu.cn.homework.admin.entity.College;
import gzhu.edu.cn.homework.admin.entity.Major;
import gzhu.edu.cn.homework.admin.service.MajorService;

/**
 * Servlet implementation class MajorServlet
 */
public class MajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MajorService majorService = new MajorService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method==null) {
			//跳转到专业的显示界面
		}
		else {
			switch (method) {
			case "add":
				addMajor(request,response);
				break;
			case "addAction":
				addMajorAtion(request,response);
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
	
	/**
	   * 跳转到新增专业页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private  void addMajor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String collegeId=  request.getParameter("collegeId");
		request.setAttribute("collegeId", collegeId);
		
		request.getRequestDispatcher("addMajor.jsp").forward(request, response);
		
	}
	

	/**
	   * 处理新增专业页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private  void addMajorAtion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String collegeId=  request.getParameter("collegeId");
		String name = request.getParameter("name").trim();
		String description = request.getParameter("description").trim();
		Major major = new Major();
		College college = new College();
		college.setId(Integer.parseInt(collegeId));
		major.setCollege(college);
		major.setDescription(description);
		major.setName(name);
		majorService.saveMajor(major);
		request.getRequestDispatcher("addMajor.jsp").forward(request, response);
		
	}


}
