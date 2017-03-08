/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO.impl;

import com.leapfrog.DAO.PaymentDAO;
import com.leapfrog.dbconnection.DbConnection;
import com.leapfrog.entity.Payment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class PaymentDAOImpl implements PaymentDAO {

    DbConnection db = new DbConnection();

    @Override
    public int insert(Payment p) throws SQLException, ClassNotFoundException {
        String sql = "Insert into payments(payment_id,enrollment_id,amount) values(?,?,?)";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, p.getId());
        stmt.setInt(2, p.getEnrollment().getId());
        stmt.setInt(3, p.getAmount());
        int result = stmt.executeUpdate();
        return result;
    }

    @Override
    public List<Payment> getAll() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment getById(int id) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Payment t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Payment t) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Payment remainingAmount(int enrollment_id) throws SQLException, ClassNotFoundException {
        String sql = "Select e.fees,sum(p.amount) as total_paid ,(e.fees-sum(p.amount))as remaining from enrollment e join payments p on p.enrollment_id=e.enrollment_id  where e.enrollment_id=?";
        db.open();
        Payment payment=null;
        int remainingAmount = 0;
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, enrollment_id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            payment = new Payment();
            payment.setAmount(rs.getInt("total_paid"));

            payment.setRemaining(rs.getInt("remaining"));
           // remainingAmount = payment.getRemaining();
            //System.out.println(remainingAmount);

        }
        return payment;

    }

}
