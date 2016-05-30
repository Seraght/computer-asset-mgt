/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.ComputerSpec;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class EditAssetReal extends HttpServlet {

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
        
        
        int assetID = Integer.parseInt(request.getParameter("assetID"));
        Computer editComputer = Asset.searchByID(assetID);
        
        editComputer.setAssetNumber(request.getParameter("assetNumber"));
        double price = Double.parseDouble(request.getParameter("price"));
        editComputer.setPrice(price);
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        editComputer.setTypeID(typeID);
        String serial = request.getParameter("serial");
        editComputer.setSerial(serial);
        
        Map properties = new HashMap();
        properties.put("model", request.getParameter("model"));
        properties.put("brand", request.getParameter("brand"));
        properties.put("description", request.getParameter("description"));
        ComputerSpec addSpec = new ComputerSpec(properties);
        editComputer.setSpec(addSpec);
        
        Asset in = new Asset();
        Boolean result = in.updateComputer(editComputer);
        
        if (result != false) {
            message = "การแก้ไขครุภัณฑ์หมายเลข " + assetID + " ประสบความสำเร็จ";
            
        } else {
            message = "การแก้ไขครุภัณฑ์หมายเลข " + assetID + " ไม่สำเร็จ";
        }
        target = "/back/edit_asset_result.jsp";

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
