package com.ekart.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ekart.user.dao.CartDao;
import com.ekart.user.dao.impl.CartDaoImpl;
import com.ekart.user.entity.Cart;
import com.ekart.user.entity.Customer;
import com.ekart.util.Const;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/customer/cart/*")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		CartDao cDao = new CartDaoImpl();
		HttpSession session = request.getSession();
		Customer cObj = (Customer) session.getAttribute("customer");

		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			String pid = request.getParameter("pid");
			String quantity = request.getParameter("quantity");
			int uid = cObj.getId();
			String pName = "";

			Cart cart = new Cart();
			cart.setPid(Integer.parseInt(pid));
			cart.setUid(uid);
			cart.setQuantity(Integer.parseInt(quantity));
			cart.setProductName(pName);

			try {
				cDao.insert(cart);
				int iquantity = cDao.totalQuantity(cDao.getAllByUid(uid));
				response.getWriter().append("" + iquantity);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else if (null != pathInfo && pathInfo.equalsIgnoreCase("/list")) {
			request.getRequestDispatcher(Const.SITE + "checkout.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
			String pid = request.getParameter("pid");
			response.getWriter().append(" Product id : " + pid);
		} else if (null != pathInfo && pathInfo.equalsIgnoreCase("/list")) {
			String pid = request.getParameter("pid");
			String quantity = request.getParameter("quantity");
			response.getWriter().append(quantity);
		}
	}

}
