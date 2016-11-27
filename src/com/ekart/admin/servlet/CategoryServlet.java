package com.ekart.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekart.admin.service.CategoryService;
import com.ekart.admin.service.impl.CategoryServiceImpl;
import com.ekart.user.entity.Category;
import com.ekart.util.Const;


@WebServlet("/backend/category/*")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public CategoryServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader( "Pragma", "no-cache" );
		response.setHeader( "Cache-Control", "no-cache" );
		response.setDateHeader( "Expires", 0 );
		
		String pathInfo = request.getPathInfo();
		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			request.getRequestDispatcher(Const.BAKEND+"category_add.jsp").forward(request, response);
		}if (null != pathInfo && pathInfo.equalsIgnoreCase("/list")) {
			
			try{
			CategoryService categoryService = new CategoryServiceImpl();
			List<Category> categories = categoryService.getAll();
			request.setAttribute("category_list", categories);			
			request.getRequestDispatcher(Const.BAKEND+"category_list.jsp").forward(request, response);
			}catch(Exception ex){
				ex.printStackTrace();
			}
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			addCategory(request, response);
		}
	}

}
