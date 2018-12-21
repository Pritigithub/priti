/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.text.*;

/**
 *
 * @author AAMIR
 */
public class Date {

    public String getDate() throws Exception
    {

       //Date d=new Date();
       DateFormat d3=new SimpleDateFormat("dd-MMM-yyyy");

       String nd=d3.format(new Date());
        return nd;
    }

    public String getHH24() throws Exception
    {

       Date d=new Date();
       DateFormat d3=new SimpleDateFormat("HH:MM:SS");

       String nd=d3.format(d);
        return nd;
    }

}
