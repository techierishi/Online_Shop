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

/**
 * Servlet implementation class AddCategoryServlet
 */
@WebServlet("/backend/category/*")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategoryServlet() {
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

		String pathInfo = request.getPathInfo();
		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			request.getRequestDispatcher("backend/category_add.jsp").forward(request, response);
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
		request.getRequestDispatcher("backend/category_add.jsp").forward(request, response);

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
