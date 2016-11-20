/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.service;

import com.ekart.entity.Member;
import java.sql.SQLException;

/**
 *
 * @author Rishikesh
 */
public interface MemberService extends GenericService<Member> {
    public Member authenticate(String email, String password) throws SQLException, ClassNotFoundException;
    
}
