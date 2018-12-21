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

/**
 *
 * @author AAMIR
 */
public class AddCardServ extends org.apache.struts.action.Action {
    
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
           int prdno=Integer.parseInt(request.getParameter("prdno"));
           ProductDataModel pdm=new ProductDataModel();
           Product pro1=pdm.searchPno(prdno);

            OrderDataModel or=new OrderDataModel();

            HttpSession hs=request.getSession();

            Buyers buy=(Buyers)hs.getAttribute("user");

            //int ordid=(Integer)hs.getAttribute("ordid");
//            if(hs.getAttribute("ordid")==null)
//            {
                int ordid=or.getOrdID();
                hs.setAttribute("ordid",ordid);
           // }
            
           ArrayList Shopping1= (ArrayList)hs.getAttribute("shoppinglist");
           int Total=(Integer)hs.getAttribute("Total");
            Shopping shop=new Shopping();
            shop.setOrdid((Integer)hs.getAttribute("ordid"));
            shop.setPrdname(pro1.getPrdname());
            shop.setPrdno(pro1.getPrdno());
            shop.setPrice(pro1.getPrice());
            Total=Total+pro1.getPrice();
            shop.setUsername(buy.getUsername());
            //response.sendRedirect("error.jsp?msg="+shop.getUsername());
           Shopping1.add(shop);
            hs.setAttribute("shoppinglist", Shopping1);
            hs.setAttribute("Total", Total);



        return mapping.findForward(SUCCESS);
    }
}
