/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO;

import com.leapfrog.entity.Payment;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public interface PaymentDAO extends GenericDAO<Payment> {
    
    public Payment remainingAmount(int enrollment_id) throws SQLException, ClassNotFoundException;
    
}
