/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.user.service;

import com.ekart.user.entity.Book;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rishikesh
 */
public interface BookService extends GenericService<Book>{
    public List<Book> getByAuthor(String authorName)throws ClassNotFoundException, SQLException;
    public List<Book> getByMostEnquiries()throws ClassNotFoundException, SQLException;
    public List<Book> getByLatestPublishedDate()throws ClassNotFoundException, SQLException;
    public List<Book> getBorrowedBooks(int memberId)throws ClassNotFoundException, SQLException;
}