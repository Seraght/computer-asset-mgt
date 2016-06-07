/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.DeliverAsset;
import com.asset.model.Person;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Deliver extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message = "";
        String target = null;
        boolean result = false;

        String assetKey = request.getParameter("assetKey");

        String assetYear = assetKey.substring(0, 2);
        int assetGet = Integer.parseInt(assetKey.substring(3, 4));
        String assetNumber = assetKey.substring(5, 8);
        int assetType = Integer.parseInt(assetKey.substring(9, 10));
        int personID = Integer.parseInt(request.getParameter("personID"));

        DeliverAsset newDeliver = new DeliverAsset(personID, assetYear, assetGet, assetNumber, assetType);

        DeliverAsset oldDeliver = DeliverAsset.searchByPerson(personID);

        if (oldDeliver != null) {
            request.setAttribute("newDeliver", newDeliver);
            request.setAttribute("oldDeliver", oldDeliver);
            Computer nc = Asset.searchByID(assetYear, assetGet, assetNumber, assetType);
            request.setAttribute("newComputer", nc);
            message = "คุณต้องการทดแทนครุภัณฑ์หมายเลข "+assetYear + "-" + assetGet + "-" + assetNumber + "-" + assetType
                    + " ด้วยครุภัณฑ์หมายเลข " + oldDeliver.getC().getAssetYear()+ "-" + oldDeliver.getC().getAssetGet()+ "-" + oldDeliver.getC().getAssetNumber()+ "-" + oldDeliver.getC().getTypeID()
                    + " ให้กับเจ้าหน้าที่ " + oldDeliver.getP().getFirstName() + " " + oldDeliver.getP().getLastName() + 
                    " หรือไม่";
            target = "/back/deliver_replace.jsp";
        } else {
            result = newDeliver.insertDeliverAsset(newDeliver);
            if (result != false) {
                message = "ได้ส่งมอบครุภัณฑ์หมายเลข " + assetYear + "-" + assetGet + "-" + assetNumber + "-" + assetType + " ให้กับ " + personID + "เรียบร้อยแล้ว";
                Asset a = new Asset();
                Boolean ra = a.updateOwner(1, assetYear, assetGet, assetNumber, assetType);
                Person p = new Person();
                Boolean rp = p.updateAsset(1, personID);
            } else {
                message = "การส่งมอบครุภัณฑ์หมายเลข " + assetYear + "-" + assetGet + "-" + assetNumber + "-" + assetType + " ไม่สำเร็จ";
            }
            target = "/back/deliver_result.jsp";
        }

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(target).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
