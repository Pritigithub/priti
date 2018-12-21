/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author AAMIR
 */
public class OrderProduct extends org.apache.struts.action.Action {
    
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

        int prono=Integer.parseInt(request.getParameter("prdno"));
        HttpSession hs = request.getSession();
        String log = (String)hs.getAttribute("login");
        ProductDataModel p1=new ProductDataModel();
        if(log == null){
            response.sendRedirect("login.jsp");
        }else {
            OrderDataModel o=new OrderDataModel();
            int ordid=o.getOrdID();
            Product p=p1.searchPno(prono);
            if(p!=null)
            {
                request.setAttribute("pro", p);
            }

        }

        return mapping.findForward(SUCCESS);
    }
}
