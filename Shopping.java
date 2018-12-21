/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

/**
 *
 * @author AAMIR
 */
public class Shopping {
private int prdno;
private String prdname;
private int price;
private int ordid;
private String username;

    /**
     * @return the prdno
     */
    public int getPrdno() {
        return prdno;
    }

    /**
     * @param prdno the prdno to set
     */
    public void setPrdno(int prdno) {
        this.prdno = prdno;
    }

    /**
     * @return the prdname
     */
    public String getPrdname() {
        return prdname;
    }

    /**
     * @param prdname the prdname to set
     */
    public void setPrdname(String prdname) {
        this.prdname = prdname;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the ordid
     */
    public int getOrdid() {
        return ordid;
    }

    /**
     * @param ordid the ordid to set
     */
    public void setOrdid(int ordid) {
        this.ordid = ordid;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

}
