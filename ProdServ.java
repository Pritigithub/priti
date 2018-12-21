/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.hibernate.*;

/**
 *
 * @author AAMIR
 */
public class ProdServ extends org.apache.struts.action.Action {
    
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
        Session session = sf.openSession();
        Transaction tx = null;
        Product eb=(Product)form;
        Productcat pc=new   Productcat(eb.getProcatid());
        eb.setProductcat(pc);


       FormFile mfile=eb.getPic();
       String fname=mfile.getFileName();
       String filePath=getServlet().getServletContext().getRealPath("/")+"upload";
       File ftc=new File(filePath,fname);
       try{
       if(!ftc.exists())
       {
           eb.setPhoto(fname);
           FileOutputStream fos=new FileOutputStream(ftc);
           fos.write(mfile.getFileData());
           fos.flush();
           tx = session.beginTransaction();

           session.save(eb);


          tx.commit();
           fos.close();



          request.setAttribute("msg", "file uploaded successfully...");

       }
       else
       {
        request.setAttribute("msg", "file alrady exist...");
       }
       }catch(HibernateException e)
       {
        response.sendRedirect("error.jsp?msg="+e.toString());
       }


        
        return mapping.findForward(SUCCESS);
    }
}
