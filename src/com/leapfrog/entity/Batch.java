/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.entity;

/**
 *
 * @author Lenovo
 */
public class Batch {
    private int id;
    
    private String batch_code;
    private Course course;
    private Facilitator facilitator;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Facilitator getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(Facilitator facilitator) {
        this.facilitator = facilitator;
    }
    
    
    
    
    
    
}
