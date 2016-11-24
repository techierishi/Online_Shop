package com.ekart.admin.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekart.admin.service.CategoryService;
import com.ekart.admin.service.impl.CategoryServiceImpl;
import com.ekart.user.entity.Category;
import com.ekart.util.Const;

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/backend/category/*")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader( "Pragma", "no-cache" );
		response.setHeader( "Cache-Control", "no-cache" );
		response.setDateHeader( "Expires", 0 );
		
		System.out.println("GET home");

		String pathInfo = request.getPathInfo();
		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			request.getRequestDispatcher(Const.BAKEND+"category_add.jsp").forward(request, response);
		}
	}

	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		CategoryService categoryService = new CategoryServiceImpl();
		String category_name = request.getParameter("category_name");
		String category_detail = request.getParameter("category_detail");
		try {
			Category category = new Category();
			category.setCategory_name(category_name);
			category.setCategory_detail(category_detail);
			categoryService.insert(category);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		request.getSession().setAttribute("message", "Category Added successfully!");
		response.sendRedirect(request.getContextPath()+"/backend/category/add");
		//request.getRequestDispatcher(Const.BAKEND+"category_add.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			addCategory(request, response);
		}
	}

}
