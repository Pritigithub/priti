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
public class ProductDataModel {
public String insert(Product rb) throws Exception
  {


       Class.forName("oracle.jdbc.driver.OracleDriver");
       Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("insert into Product values(?,?,?,?,?,?,?)");
       pst.setInt(1, rb.getPrdno());
       pst.setString(2, rb.getPrdname());
      pst.setInt(3, rb.getPrice());
       pst.setString(4, rb.getDescription());
       pst.setString(5, rb.getMfg());
       pst.setString(6, rb.getPhoto());
       pst.setInt(7,rb.getProcatid());

       pst.executeUpdate();
       con.close();
       return "success";


 }
 public Product searchPno( int prdno) throws Exception
  {
     Product r = null;
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("select * from Product where prdno = ?");
       pst.setInt(1, prdno);
       ResultSet rs = pst.executeQuery();
       if( rs.next())
       {
         r = new Product();
         
         r.setPrdno(rs.getInt(1));
        r.setPrdname(rs.getString(2));
        r.setPrice(rs.getInt(3));
        r.setDescription(rs.getString(4));
        r.setMfg(rs.getString(5));
        r.setPhoto(rs.getString(6));
        r.setProcatid(rs.getInt(7));
        }
       con.close();
       return r;
   }
public String deleteproduct(int prdno) throws Exception
  {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","shops", "shops");

       PreparedStatement pst = con.prepareStatement("delete from product where prdno = ?");
       pst.setInt(1, prdno);

      int x = pst.executeUpdate();
       con.close();
      if(x > 0){
       return "success";
     }else{
       return "input";
     }

}
}
