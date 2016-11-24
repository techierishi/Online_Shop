/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ekart.user.dao.impl;

import com.ekart.user.dao.GenreDAO;
import com.ekart.user.entity.Genre;
import com.ekart.util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GenreDAOImpl implements GenreDAO {
    private DBConnection conn;

    public GenreDAOImpl() {
        conn = new DBConnection();
    }

    @Override
    public int insert(Genre genre) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO tbl_genre(name) VALUES (?)";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        pst.setString(1, genre.getName());
        return pst.executeUpdate();
    }

    @Override
    public int update(Genre t) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Genre> getAll() throws ClassNotFoundException, SQLException {
        List<Genre> genreList = new ArrayList<Genre>();
        String SQL = "SELECT * FROM tbl_genre";
        conn.open();
        PreparedStatement pst = conn.initStatement(SQL);
        conn.close();
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Genre genre = new Genre();
            genre.setId(rs.getInt("id"));
            genre.setName(rs.getString("name"));
            genreList.add(genre);
        }
        return genreList;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genre getById(int id) throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
