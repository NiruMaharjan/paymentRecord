/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO.impl;

import com.leapfrog.DAO.StudentDAO;
import com.leapfrog.dbconnection.DbConnection;
import com.leapfrog.entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class StudentDAOImpl implements StudentDAO {
DbConnection db=new DbConnection();
    @Override
    public int insert(Student t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getById(int id) throws SQLException, ClassNotFoundException {
        String sql="Select *from students where student_id=?";
        Student student=null;
        db.open();
        PreparedStatement stmt=db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs=stmt.executeQuery();
        while(rs.next()){
             student=new Student();
            student.setId(rs.getInt("student_id"));
            student.setFirst_name(rs.getString("first_name"));
            student.setLast_name(rs.getString("last_name"));
            student.setEmail(rs.getString("email"));
            student.setContact(rs.getString("contact_no"));
            student.setStatus(rs.getBoolean("status"));
        }
        return student;
        
    }

    @Override
    public int delete(Student t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Student t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
