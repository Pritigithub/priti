/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.ArrayList;
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
public class LogServ extends org.apache.struts.action.Action {
    
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
         SessionFactory sf=HibernateUtil.getSessionFactory();
        Session se=sf.openSession();
        Buyers ff=(Buyers)form;
        Transaction tx=null;
        try{
            Buyers fa=null;
            se.beginTransaction();
            fa=(Buyers)se.get(Buyers.class, ff.getUsername());

            if(fa!=null && fa.getPassword().equals(ff.getPassword()))
            {
                HttpSession hs=request.getSession();
                hs.setAttribute("user",fa);
                ArrayList Shopping=new ArrayList();
                int Total=0;
                hs.setAttribute("shoppinglist", Shopping);
                hs.setAttribute("Total", Total);
                hs.setAttribute("login", "yes");
            }

        else
            {
                response.sendRedirect("login.jsp?msg=Invalid Username Password");
            }
        }catch(Exception e)
        {
        response.sendRedirect("error.jsp?msg="+e.toString());

        }
        return mapping.findForward(SUCCESS);
    }
}
