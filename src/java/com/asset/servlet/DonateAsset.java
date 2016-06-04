/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class DonateAsset extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        String target = "";
        String message = "";
        String donateTime = request.getParameter("donateTime");
        String[] donateAsset = request.getParameterValues("donateAsset");
        

        int index = 0;

        while (index < donateAsset.length) {
            List<String> items = Arrays.asList(donateAsset[index].split("-"));
            String assetYear = items.get(0);
            int assetGet = Integer.parseInt(items.get(1));
            String assetNumber = (items.get(2));
            int typeID = Integer.parseInt(items.get(3));
            Asset a = new Asset();
            Boolean result = a.donateComputer(assetYear, assetGet, assetNumber, typeID,donateTime);
            if (result != false) {
                message += "ทำการบริจาคครุภัณฑ์หมายเลข " + assetYear + "-" + assetGet + "-" + assetNumber + "-" + typeID + " เรียบร้อยแล้ว<br>";

            } else {
                message += "การบริจาคครุภัณฑ์หมายเลข " + assetYear + "-" + assetGet + "-" + assetNumber + "-" + typeID + " ผิดพลาด<br>";
            }
            index++;
        }

        target = "/back/donate_asset_result.jsp";

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
