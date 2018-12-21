/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.sql.*;

/**
 *
 * @author AAMIR
 */
public class OrderDataModel {
 public String insert(Orders rb) throws Exception
  {
    if(rb != null)
     {
       if(rb.getOrdid() <= 0)
        {
          return "input";
        }
       else if(rb.getOrderdt().equals(""))
        {
          return "input";
        }

       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("insert into orders values(?,?,?,?,?)");
       pst.setInt(1, rb.getOrdid());
       pst.setString(2, rb.getOrderdt());
       pst.setString(3, rb.getOrdtime());
       pst.setInt(4, rb.getOrdamnt());
       pst.setString(5, rb.getUsername());
      
       pst.executeUpdate();
       con.close();
       return "success";
     }else{
       return "input";
     }

 }
 public Orders searchid( int ordid) throws Exception
  {
     Orders r = null;
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("select * from orders where ordid = ?");
       pst.setInt(1, ordid);
       ResultSet rs = pst.executeQuery();
       if( rs.next())
       {
         r = new Orders();
         r.setOrdid(rs.getInt(1));
         r.setOrderdt(rs.getString(2));
         r.setOrdtime(rs.getString(3));
         r.setOrdamnt(rs.getInt(4));
        r.setBuyers(new Buyers (rs.getString(5)));

       }
       con.close();
       return r;
   }
public Orders searchUname( String username) throws Exception
  {
     Orders r = null;
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("select * from orders where username = ?");
       pst.setString(1, username);
       ResultSet rs = pst.executeQuery();
       if( rs.next())
       {
         r = new Orders();
         r.setOrdid(rs.getInt(1));
         r.setOrderdt(rs.getString(2));
         r.setOrdtime(rs.getString(3));
         r.setOrdamnt(rs.getInt(4));
         r.setBuyers(new Buyers (rs.getString(5)));


       }
       con.close();
       return r;
   }
public String deleteorder(int ordid) throws Exception
  {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("delete from orders where ordid = ?");
       pst.setInt(1, ordid);

      int x = pst.executeUpdate();
       con.close();
      if(x > 0){
       return "success";
     }else{
       return "input";
     }

}

public int getOrdID() throws Exception
  {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("select ordid.nextval from dual");

       int x = pst.executeUpdate();
       con.close();

       return x;


}


}

