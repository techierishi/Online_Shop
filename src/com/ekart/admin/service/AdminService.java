/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.admin.service;

import com.ekart.admin.entity.Admin;

import com.ekart.user.service.GenericService;

import java.sql.SQLException;

/**
 *
 * @author Rishikesh
 */
public interface AdminService extends GenericService<Admin> {
    public Admin authenticate(String email, String password) throws SQLException, ClassNotFoundException;
    
}
