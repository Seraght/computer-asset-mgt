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
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class DeliverDetail extends HttpServlet {

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

        if (request.getParameter("personID") != null) {
            int personID = Integer.parseInt(request.getParameter("personID"));
            DeliverAsset da = DeliverAsset.searchByPerson(personID);
            Person p = Person.searchPerson(da.getPersonID());
            Computer c = Asset.searchByID(da.getComputerID());
            if (da == null || p == null || c == null) {
                message = "ไม่พบข้อมูลการส่งมอบ";
            } else {
                request.setAttribute("deliver", da);
                request.setAttribute("person", p);
                request.setAttribute("computer", c);
            }
        } else if (request.getParameter("assetID") != null) {
            int assetID = Integer.parseInt(request.getParameter("assetID"));
            DeliverAsset da = DeliverAsset.searchByComputer(assetID);
            Person p = Person.searchPerson(da.getPersonID());
            Computer c = Asset.searchByID(da.getComputerID());
            if (da == null || p == null || c == null) {
                message = "ไม่พบข้อมูลการส่งมอบ";
            } else {
                request.setAttribute("deliver", da);
                request.setAttribute("person", p);
                request.setAttribute("computer", c);
            }
        } else {
            message = "ไม่พบข้อมูลการส่งมอบ";
        }
        
        target = "/back/deliver_detail.jsp";
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
