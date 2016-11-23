/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.dao;

import com.ekart.entity.Enquiry;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rishikesh
 */
public interface EnquiryDAO extends GenericDAO<Enquiry>{
    public List<Enquiry> getByMemberId(int memberId) throws ClassNotFoundException, SQLException;
    public List<Enquiry> getByBookId(int bookId)throws ClassNotFoundException, SQLException;
}