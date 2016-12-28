package com.ekart.user.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ekart.user.dao.CustomerDao;
import com.ekart.user.dao.impl.CustomerDaoImpl;
import com.ekart.user.entity.Customer;
import com.ekart.user.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{

	CustomerDao customerDao;
	
	
	public CustomerServiceImpl() {
		super();
		this.customerDao = new CustomerDaoImpl();
	}

	@Override
	public int insert(Customer t) throws ClassNotFoundException, SQLException {
		return customerDao.insert(t);
	}

	@Override
	public int update(Customer t) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Customer> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer getById(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
