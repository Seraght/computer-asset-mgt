/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
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
        
        int assetID = Integer.parseInt(request.getParameter("assetID"));
        int personID = Integer.parseInt(request.getParameter("personID"));
        
        DeliverAsset deliver = new DeliverAsset(personID, assetID);
        result = deliver.insertDeliverAsset(deliver);
        if (result != false) {
            message = "ได้ส่งมอบครุภัณฑ์หมายเลข " + assetID + " ให้กับ " + personID + "เรียบร้อยแล้ว";
            Asset a = new Asset();
            Boolean ra = a.updateOwner(1, assetID);
            Person p = new Person();
            Boolean rp = p.updateAsset(1, personID);
        } else {
            message = "การส่งมอบครุภัณฑ์หมายเลข " + assetID + " ไม่สำเร็จ";
        }
        target = "/back/deliver_result.jsp";

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
