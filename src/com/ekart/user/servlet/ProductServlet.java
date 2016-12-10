package com.ekart.user.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.ekart.admin.service.CategoryService;
import com.ekart.admin.service.ProductService;
import com.ekart.admin.service.impl.CategoryServiceImpl;
import com.ekart.admin.service.impl.ProductServiceImpl;
import com.ekart.user.entity.Category;
import com.ekart.user.entity.FileMeta;
import com.ekart.user.entity.Product;
import com.ekart.user.entity.ProductImage;
import com.ekart.util.Const;
import com.ekart.util.MultipartRequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "ProductServlet1", urlPatterns = { "/product/*" })
       public class ProductServlet extends HttpServlet {
    	private static final long serialVersionUID = 1L;

    	public ProductServlet() {
    		super();
    	}

    	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    			throws ServletException, IOException {
    		response.setHeader("Pragma", "no-cache");
    		response.setHeader("Cache-Control", "no-cache");
    		response.setDateHeader("Expires", 0);

    		String pathInfo = request.getPathInfo();
    		
    		if (null != pathInfo && pathInfo.equalsIgnoreCase("/list")) {

    			try {
    				ProductService productService = new ProductServiceImpl();
    				List<Product> products = productService.getAll();
    				request.setAttribute("product_list", products);
    				request.getRequestDispatcher(Const.SITE + "products.jsp").forward(request, response);
    			} catch (Exception ex) {
    				ex.printStackTrace();
    			}
    		}
    	}

	
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	String pathInfo = request.getPathInfo();
	if (null != pathInfo && pathInfo.equalsIgnoreCase("/add")) {
		addProduct(request, response);
	} else if (null != pathInfo && pathInfo.equalsIgnoreCase("/uploadimg")) {
		List<FileMeta> files = new LinkedList<FileMeta>();

		// 1. Upload File Using Apache FileUpload
		files.addAll(MultipartRequestHandler.uploadByJavaServletAPI(request));

		for (FileMeta filem : files) {
			MultipartRequestHandler.uploadFileNow(request, filem.getFileName(), filem.getContent());
		}
		// Remove some files
		while (files.size() > 20) {
			files.remove(0);
		}

		System.out.println("Files : " + files);

		// 2. Set response type to json
		response.setContentType("application/json");

		// 3. Convert List<FileMeta> into JSON format
		ObjectMapper mapper = new ObjectMapper();

		// 4. Send result to client
		mapper.writeValue(response.getOutputStream(), files);
	}
}

private void addProduct(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub
	
}

}