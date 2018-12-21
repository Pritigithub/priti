package com.myapp.struts;
// Generated Apr 25, 2015 10:09:26 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Buyers generated by hbm2java
 */
public class Buyers extends org.apache.struts.action.ActionForm implements java.io.Serializable {


     private String username;
     private String password;
     private String name;
     private String address;
     private String city;
     private String state;
     private Integer pincode;
     private String email;
     private Long mobile;
     private Set confirmations = new HashSet(0);
     private Set orderses = new HashSet(0);

    public Buyers() {
    }

	
    public Buyers(String username) {
        this.username = username;
    }
    public Buyers(String username, String password, String name, String address, String city, String state, Integer pincode, String email, Long mobile, Set confirmations, Set orderses) {
       this.username = username;
       this.password = password;
       this.name = name;
       this.address = address;
       this.city = city;
       this.state = state;
       this.pincode = pincode;
       this.email = email;
       this.mobile = mobile;
       this.confirmations = confirmations;
       this.orderses = orderses;
    }
   
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    public Integer getPincode() {
        return this.pincode;
    }
    
    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getMobile() {
        return this.mobile;
    }
    
    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }
    public Set getConfirmations() {
        return this.confirmations;
    }
    
    public void setConfirmations(Set confirmations) {
        this.confirmations = confirmations;
    }
    public Set getOrderses() {
        return this.orderses;
    }
    
    public void setOrderses(Set orderses) {
        this.orderses = orderses;
    }




}


