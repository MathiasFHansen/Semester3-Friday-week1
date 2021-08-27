/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.friday.week1;

/**
 *
 * @author didas
 */
class User {
    
    private int ID;
    private String fname;
    private String lname;
    private String pw;
    private String phone;
    private String address;

    public User(int ID, String fname, String lname, String pw, String phone, String address) {
        this.ID = ID;
        this.fname = fname;
        this.lname = lname;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return Integer.toString(ID) + " " + fname + " " + lname + " " + pw + " " + phone + " " + address;
    }
    
    
    
    
    
}
