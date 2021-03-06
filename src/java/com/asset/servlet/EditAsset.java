/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.InsertBrand;
import com.asset.model.InsertProperties;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class EditAsset extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String target = "";
        String message = "";
        String assetYear = request.getParameter("assetYear");
        int assetGet = Integer.parseInt(request.getParameter("assetGet"));
        String assetNumber = request.getParameter("assetNumber");
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        
        
        List<InsertProperties> is = InsertProperties.searchAllType();
        List<InsertBrand> ib = InsertBrand.searchAllBrand();
        request.setAttribute("properties", is);
        request.setAttribute("brand", ib);
        
        Computer c = Asset.searchByID(assetYear,assetGet,assetNumber,typeID);
        
        if (c != null) {
            request.setAttribute("computer", c);
            message = "ค้นพบ";
        } else {
            message = "ไม่ค้นพบ";
        }
        
        target = "/back/edit_asset.jsp";
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
