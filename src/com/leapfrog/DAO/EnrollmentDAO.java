/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.DAO;

import com.leapfrog.entity.Enrollment;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */
public interface EnrollmentDAO extends GenericDAO<Enrollment>{
    Enrollment getByBatchCode(String batchCode,int student_id) throws SQLException,ClassNotFoundException;
    
    
}
