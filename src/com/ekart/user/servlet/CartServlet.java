package com.ekart.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart/*")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			String pid = request.getParameter("pid");
			String quantity = request.getParameter("quantity");
			response.getWriter().append(quantity);
		}	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			String pid= request.getParameter("pid");
			response.getWriter().append(" Product id : "+pid);
		}
	}

}
