/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.ComputerSpec;
import com.asset.model.InsertBrand;
import com.asset.model.InsertGet;
import com.asset.model.InsertProperties;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class SearchAsset extends HttpServlet {

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
        String message = "";
        String target = null;
        int count = 0;
        String subYear = null;
        int getID = 0;
        int getType = 0;

        String assetYear = request.getParameter("assetYear");
        if (assetYear != "") {
            subYear = assetYear.substring(3);
        }
        
        int assetGet = Integer.parseInt(request.getParameter("assetGet"));
        if (assetGet != 0) {
            getID = assetGet;
        }
        
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        if (typeID != 0) {
            getType = typeID;
        }
        
        Map properties = new HashMap();
        properties.put("model", request.getParameter("model"));
        properties.put("brand", request.getParameter("brand"));
        ComputerSpec specSearch = new ComputerSpec(properties);
        String serial = request.getParameter("serial");
        Computer computerSearch = new Computer(subYear,getID,typeID, serial, specSearch);
        List<Computer> computers = Asset.searchComputer(computerSearch);
        
        List<InsertProperties> is = InsertProperties.searchAllType();
        List<InsertBrand> ib = InsertBrand.searchAllBrand();
        List<InsertGet> ig = InsertGet.searchAllGet();
        
        request.setAttribute("properties", is);
        request.setAttribute("brand", ib);
        request.setAttribute("get", ig);

        if (computers != null) {
            for (int i = 1;i <= computers.size();i++) {
                count++;
            }
            message = "พบครุภัณฑ์จำนวนทั้งสิ้น " + count + " รายการ";
            request.setAttribute("computers", computers);
        } else {
            message = "ไม่พบรายการครุภัณฑ์ที่ค้นหา";
        }
        target = "/back/search_form.jsp";
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
