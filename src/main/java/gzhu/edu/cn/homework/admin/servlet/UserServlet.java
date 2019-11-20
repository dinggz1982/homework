package gzhu.edu.cn.homework.admin.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import gzhu.edu.cn.homework.admin.entity.School;
import gzhu.edu.cn.homework.admin.entity.User;
import gzhu.edu.cn.homework.admin.service.SchoolService;
import gzhu.edu.cn.homework.admin.service.UserService;
import gzhu.edu.cn.homework.utils.Page;

/**
 * 用户管理
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private SchoolService schoolService = new SchoolService();
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method == null) {
			listUser(request, response);
		} else {
			switch (method) {
			case "add":

				break;
			case "import":
				importUser(request, response);
				break;
			case "fileUpload":
					fileUpload(request,response);
				break;
			default:
				listUser(request, response);
			}
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

	/**
	 * 用户列表
	 * 
	 * @author dinggz
	 * @date 2019年11月13日 下午10:44:33
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String currentPageStr = request.getParameter("currentPage");
		int currentPage;
		if (currentPageStr == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageStr);
		}

		String sizeStr = request.getParameter("size");
		int size;
		if (sizeStr == null) {
			size = 10;
		} else {
			size = Integer.parseInt(sizeStr);
		}
		Page<User> page = this.userService.getPage(currentPage, size, null);
		request.setAttribute("page", page);
		request.getRequestDispatcher("user.jsp").forward(request, response);
	}
	
	/**
	 * 导入用户页面
	 * @author dinggz
	 * @date 2019年11月20日 下午9:15:00
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void importUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<School> schools = this.schoolService.getAllSchool();
		request.setAttribute("schools", schools);
		request.getRequestDispatcher("importUser.jsp").forward(request, response);
	}

	/**
	 *  处理文件上传
	 * @author dinggz
	 * @date 2019年11月13日 下午11:53:00
	 * @param request
	 * @param response
	 * @throws UnsupportedEncodingException 
	 * @throws FileUploadException 
	 * @throws IOException 
	 */
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload fileUpload = new ServletFileUpload(factory);
				List<FileItem> files;
				// 解决json中文乱码
				request.setCharacterEncoding("UTF-8");
		        response.setContentType("text/json;charset=UTF-8");
		        response.setCharacterEncoding("UTF-8");
		        String school_id = request.getParameter("school_id");
		        PrintWriter out = null;
				try {
					out = response.getWriter();
					files = fileUpload.parseRequest(request);
					for (Iterator iterator = files.iterator(); iterator.hasNext();) {
						FileItem fileItem = (FileItem) iterator.next();
						if(!fileItem.getName().equals("")&&fileItem.getName()!=null) {
						//System.out.println(fileItem.getName());
						String parentPath = this.getServletContext().getRealPath("/upload");
						//System.out.println(parentPath);
						File parentDir = new File(parentPath);
						if(!parentDir.exists()) {
							parentDir.mkdirs();
						}
						File file = new File(parentDir,fileItem.getName());
						InputStream is = null;
						OutputStream os = null;
							is = fileItem.getInputStream();
							os = new FileOutputStream(file);
							
							byte[] by = new byte[1024];
							int len = -1;
							while((len=is.read(by))!=-1){
								os.write(by);
							}
							is.close();
							os.close();
							
							String str ="{\"status\":\"success\"}";
					        out.println(str);
					        out.flush();
					        out.close();
						}
					}
				} catch (FileUploadException | IOException e1 ) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					//输出json数据
					String str ="{\"status\":\"fail\"}";
			        out.println(str);
			        out.flush();
			        out.close();
				}
				
	}
	
	
}
