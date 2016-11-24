/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.user.servlet;

import com.ekart.user.entity.Book;
import com.ekart.user.entity.Genre;
import com.ekart.user.entity.Member;
import com.ekart.user.service.BookService;
import com.ekart.user.service.GenreService;
import com.ekart.user.service.MemberService;
import com.ekart.user.service.impl.BookServiceImpl;
import com.ekart.user.service.impl.GenreServiceImpl;
import com.ekart.user.service.impl.MemberServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rishikesh
 */
@WebServlet (urlPatterns = "/memberLogin")
public class MemberLoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/member/login.jsp");

	}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberService memberService = new MemberServiceImpl();        
        BookService bookService = new BookServiceImpl();
        Member member = null;
        List<Book> latestBookList, borrowedBookList = null;
        List<Genre> genreList = null;
        try {
            member = memberService.authenticate(req.getParameter("email"), req.getParameter("password"));
            if(member != null){
                
                latestBookList = bookService.getByLatestPublishedDate();                
                HttpSession session = req.getSession(true);
                session.setAttribute("memberLogin", true);
                session.setAttribute("member", member);
                session.setAttribute("latestBookList", latestBookList);                
                resp.sendRedirect(req.getContextPath()+"/member/memberDashboard.jsp");
            }
             else{
                resp.sendRedirect(req.getContextPath()+"/member/login.jsp?error=loginError");
                }
        } catch (SQLException ex) {
            Logger.getLogger(MemberLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
