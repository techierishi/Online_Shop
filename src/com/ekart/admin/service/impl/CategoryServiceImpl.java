/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.admin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ekart.admin.dao.CategoryDao;
import com.ekart.admin.dao.impl.CategoryDaoImpl;
import com.ekart.admin.service.CategoryService;
import com.ekart.user.entity.Category;


public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = null;

    public CategoryServiceImpl() {
    	categoryDao = new CategoryDaoImpl();
    }

	@Override
	public int insert(Category t) throws ClassNotFoundException, SQLException {
		return categoryDao.insert(t);
	}

	@Override
	public int update(Category t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> getAll() throws ClassNotFoundException, SQLException {
		
		return categoryDao.getAll();
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category getById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}
    

      
}
