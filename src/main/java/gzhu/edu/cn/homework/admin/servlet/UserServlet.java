package gzhu.edu.cn.homework.admin.servlet;

import java.io.File;
import java.io.IOException;
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

import gzhu.edu.cn.homework.admin.entity.User;
import gzhu.edu.cn.homework.admin.service.UserService;
import gzhu.edu.cn.homework.utils.Page;

/**
 * 用户管理
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

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
			case "fileUpload":
				try {
					fileUpload(request,response);
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
	 *  处理文件上传
	 * @author dinggz
	 * @date 2019年11月13日 下午11:53:00
	 * @param request
	 * @param response
	 * @throws FileUploadException 
	 * @throws IOException 
	 */
	public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload fileUpload = new ServletFileUpload(factory);
				List<FileItem> files = fileUpload.parseRequest(request);
				for (Iterator iterator = files.iterator(); iterator.hasNext();) {
					FileItem fileItem = (FileItem) iterator.next();
					System.out.println(fileItem.getName());
					String parentPath = this.getServletContext().getRealPath("/upload");
					System.out.println(parentPath);
					File parentDir = new File(parentPath);
					if(!parentDir.exists()) {
						parentDir.mkdirs();
					}
					File file = new File(parentDir,fileItem.getName());
					fileItem.getInputStream();
				}
	}
	
}
