/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.user.service.impl;

import com.ekart.user.dao.EnquiryDAO;
import com.ekart.user.dao.impl.EnquiryDAOImpl;
import com.ekart.user.entity.Enquiry;
import com.ekart.user.service.EnquiryService;
import java.sql.SQLException;
import java.util.List;


public class EnquiryServiceImpl implements EnquiryService {
    private EnquiryDAO enquiryDAO = null;

    public EnquiryServiceImpl() {
        enquiryDAO = new EnquiryDAOImpl();
    }
    

    @Override
    public List<Enquiry> getByMemberId(int memberId) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enquiry> getByBookId(int bookId) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        return enquiryDAO.insert(enquiry);
    }

    @Override
    public int update(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        return enquiryDAO.update(enquiry);
    }

    @Override
    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        return enquiryDAO.getAll();
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        return enquiryDAO.delete(id);
    }

    @Override
    public Enquiry getById(int id) throws ClassNotFoundException, SQLException {
        return enquiryDAO.getById(id);
    }
    
}
