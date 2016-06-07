/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.Asset;
import com.asset.model.Computer;
import com.asset.model.Person;
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
public class MatchDeliver extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message = "";
        String target = null;
        
        List<Person> persons = null;
        List<Computer> computers = null;
        
        if (request.getParameter("personID") != null) {
            request.setAttribute("personID", request.getParameter("personID"));
            String name = request.getParameter("Firstname")+" "+request.getParameter("Lastname");
            request.setAttribute("personName", name);
        } else if (request.getParameter("assetYear") != null) {
            request.setAttribute("assetYear", request.getParameter("assetYear"));
            request.setAttribute("assetGet", request.getParameter("assetGet"));
            request.setAttribute("assetNumber", request.getParameter("assetNumber"));
            request.setAttribute("typeID", request.getParameter("typeID"));
        }
        
        persons = Person.searchAllPerson();
        computers = Asset.searchAllComputer();
        request.setAttribute("listPersons", persons);
        request.setAttribute("listComputers", computers);
        
        target = "/back/match_deliver.jsp";
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
