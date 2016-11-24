/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.user.dao;

import com.ekart.user.entity.Member;
import java.sql.SQLException;

/**
 *
 * @author Rishikesh
 */
public interface MemberDAO extends GenericDAO<Member> {
    public Member authenticate(String email, String password) throws SQLException, ClassNotFoundException;
}
