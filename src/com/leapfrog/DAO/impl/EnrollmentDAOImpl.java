/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO.impl;

import com.leapfrog.DAO.EnrollmentDAO;
import com.leapfrog.dbconnection.DbConnection;
import com.leapfrog.entity.Batch;
import com.leapfrog.entity.Course;
import com.leapfrog.entity.Enrollment;
import com.leapfrog.entity.Facilitator;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class EnrollmentDAOImpl implements EnrollmentDAO {

    DbConnection db = new DbConnection();

    @Override
    public int insert(Enrollment t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Enrollment> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enrollment getById(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Enrollment t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Enrollment t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enrollment getByBatchCode(String batchCode, int student_id) throws SQLException, ClassNotFoundException {
        Enrollment enrollment = null;

        String sql = "Select e.enrollment_id,b.batch_id,c.course_name,c.fees,concat(f.first_name,' ',f.last_name)as facilitator_name from enrollment e join batches b on b.batch_id=e.batch_id join courses c on c.course_id=b.course_id join facilitators f on f.facilitator_id=b.facilitator_id where batch_code=? and student_id=?";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setString(1, batchCode);
        stmt.setInt(2, student_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            enrollment = new Enrollment();
            Batch batch = new Batch();

            Course course = new Course();
            Facilitator facilitator = new Facilitator();
            enrollment.setBatch(batch);
            batch.setCourse(course);
            batch.setFacilitator(facilitator);
            enrollment.getBatch().getCourse().setName(rs.getString("course_name"));
            enrollment.setId(rs.getInt("enrollment_id"));
            enrollment.getBatch().getCourse().setFees(rs.getInt("fees"));
            batch.getFacilitator().setName(rs.getString("facilitator_name"));
            //enrollment.getBatch().getFacilitator().setLast_name("last_name");

        }
        return enrollment;

    }

}
