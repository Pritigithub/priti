/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.*;

/**
 *
 * @author AAMIR
 */
public class ShowProduct extends org.apache.struts.action.Action {
    
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
        int procatid=Integer.parseInt(request.getParameter("procatid"));
        Productcat prdct=null;
        Product prd = null;
         SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        ArrayList l = new ArrayList();
        try{
            tx = session.beginTransaction();
            prdct=(Productcat)session.get(Productcat.class,procatid);

            Iterator itr = prdct.getProducts().iterator();
            while(itr.hasNext()){
             prd = (Product)itr.next();
                   l.add(prd);
            }



            tx.commit();
            session.close();
            request.setAttribute("data", l);

        }catch(Exception e){

        }


        
        return mapping.findForward(SUCCESS);
    }
}
