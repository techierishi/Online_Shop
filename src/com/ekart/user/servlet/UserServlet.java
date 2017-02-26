package com.ekart.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ekart.admin.service.CategoryService;
import com.ekart.admin.service.impl.CategoryServiceImpl;
import com.ekart.user.entity.Category;
import com.ekart.user.entity.Customer;
import com.ekart.user.service.CustomerService;
import com.ekart.user.service.impl.CustomerServiceImpl;
import com.ekart.util.Const;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pathInfo = request.getPathInfo();
		if (null != pathInfo && pathInfo.equalsIgnoreCase("/register")) {
			try {

				request.getRequestDispatcher(Const.SITE + "register.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Customer cust = new Customer();

			cust.setName(request.getParameter("fname") + " " + request.getParameter("lname"));
			cust.setEmail(request.getParameter("email"));
			cust.setPhone(request.getParameter("phone"));
			cust.setPassword(request.getParameter("password"));

			CustomerService customerService = new CustomerServiceImpl();
			int ret = customerService.insert(cust);
			
			response.sendRedirect(request.getContextPath() + "/user/register");
		} catch (Exception ex) {
		}
	}

}
