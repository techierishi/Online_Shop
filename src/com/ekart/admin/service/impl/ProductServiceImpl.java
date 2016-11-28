package com.ekart.admin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ekart.admin.dao.ProductDao;
import com.ekart.admin.dao.ProductImageDao;
import com.ekart.admin.dao.impl.ProductDaoImpl;
import com.ekart.admin.dao.impl.ProductImageDaoImpl;
import com.ekart.admin.service.ProductService;
import com.ekart.user.entity.Product;
import com.ekart.user.entity.ProductImage;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao;
	ProductImageDao productImageDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
		productImageDao = new ProductImageDaoImpl();
	}

	@Override
	public int insert(Product t) throws ClassNotFoundException, SQLException {
		return productDao.insert(t);
	}

	@Override
	public int update(Product t) throws ClassNotFoundException, SQLException {
		return 0;
	}

	@Override
	public List<Product> getAll() throws ClassNotFoundException, SQLException {
		return productDao.getAll();
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		return 0;
	}

	@Override
	public Product getById(int id) throws ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public List<Product> getByCategory() throws SQLException {
		return null;
	}

	@Override
	public int insertImage(Product product, List<ProductImage> productImages) throws SQLException {
		return productImageDao.insert(product,productImages);
	}

}
