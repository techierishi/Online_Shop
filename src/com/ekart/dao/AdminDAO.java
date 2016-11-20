/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.dao;

import com.ekart.entity.Admin;
import java.sql.SQLException;

/**
 *
 * @author Rishikesh
 */
public interface AdminDAO extends GenericDAO<Admin>{
    public Admin authenticate(String email, String password) throws SQLException, ClassNotFoundException;
}
