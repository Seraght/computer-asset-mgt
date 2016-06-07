/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.Person;
import com.asset.model.ProblemReport;
import com.asset.model.Ticket;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class CreateTicket extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        String message = "";
        String target = null;
        Computer c = new Computer();
        
        String assetYear = request.getParameter("assetYear");
        int assetGet = Integer.parseInt(request.getParameter("assetGet"));
        String assetNumber = request.getParameter("assetNumber");
        int assetType = Integer.parseInt(request.getParameter("assetType"));
        
        
        c = Asset.searchByID(assetYear, assetGet, assetNumber, assetType);
        Person p = Person.searchPerson((int)request.getSession().getAttribute("officerID"));
        Ticket t = new Ticket(request.getParameter("ticketTitle"), request.getParameter("ticketDescription"));
        ProblemReport pr = new ProblemReport();
        Boolean result = pr.createTicket(t, p, c);
        
        if (result != false) {
            message = "การแจ้งปัญหาผ่านระบบของครุภัณฑ์หมายเลข " + request.getParameter("assetNumber") + " ประสบความสำเร็จ";
        } else {
            message = "ไม่สามารถแจ้งปัญหาของครุภัณฑ์หมายเลข " + request.getParameter("assetNumber") + " เข้าสู่ฐานข้อมูลได้";
        }
        target = "/front/add_ticket_result.jsp";

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
