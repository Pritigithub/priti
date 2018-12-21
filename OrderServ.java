/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.*;

/**
 *
 * @author AAMIR
 */
public class OrderServ extends org.apache.struts.action.Action {
    
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            //Product p=(Product)form;
            OrderDataModel ord=new OrderDataModel();
            Date d1=new Date();
          DateFormat df=new SimpleDateFormat("dd-MMM-yyyy");
          HttpSession hs = request.getSession();
          Buyers buy = (Buyers)hs.getAttribute("username");

            //int prdno=p.getPrdno();
            int cost=Integer.parseInt(request.getParameter("price"));
            int ordid=ord.getOrdID();
            String username=buy.getUsername();
           // String hour=dt.getDate();
           // String time=dt.getHH24();


            Orders o=new Orders();
            o.setOrdid(ordid);
            o.setOrderdt(df.format(new Date()));
            o.setOrdtime(d1.getHH24());
          //  o.setOrderdt(hour);
           // o.setOrdtime(time);
            o.setOrdamnt(cost);

            o.setUsername(username);

            SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            session.save(o);
            tx.commit();
            session.close();

        }catch(Exception e){

        }


        return mapping.findForward(SUCCESS);
    }
}
