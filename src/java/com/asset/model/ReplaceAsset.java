/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.model;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class ReplaceAsset extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message = "";
        String target = null;
        boolean result = false;
        String assetYear = request.getParameter("assetYear");
        int assetGet = Integer.parseInt(request.getParameter("assetGet"));
        String assetNumber = request.getParameter("assetNumber");
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        int personID = Integer.parseInt(request.getParameter("personID"));
        
        String oldAssetYear = request.getParameter("oldAssetYear");
        int oldAssetGet = Integer.parseInt(request.getParameter("oldAssetGet"));
        String oldAssetNumber = request.getParameter("oldAssetNumber");
        int oldTypeID = Integer.parseInt(request.getParameter("oldTypeID"));
        
        int deliverID = Integer.parseInt(request.getParameter("deliverID"));

        DeliverAsset newDeliver = new DeliverAsset(personID, assetYear, assetGet, assetNumber, typeID);

        result = newDeliver.insertDeliverAsset(newDeliver);
        if (result != false) {
            message = "ได้ส่งมอบครุภัณฑ์หมายเลข " + assetYear + "-" + assetGet + "-" + assetNumber + "-" + typeID + " ให้กับ " + personID + "เรียบร้อยแล้ว";
            Asset a = new Asset();
            Boolean ra = a.updateOwner(1, assetYear, assetGet, assetNumber, typeID);
            Boolean rb = a.updateOwner(0, oldAssetYear, oldAssetGet, oldAssetNumber, oldTypeID);
            DeliverAsset d = new DeliverAsset();
            Boolean rc = d.updateStatus("Cancel", deliverID);
        } else {
            message = "การส่งมอบครุภัณฑ์หมายเลข " + assetYear + "-" + assetGet + "-" + assetNumber + "-" + typeID + " ไม่สำเร็จ";
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
