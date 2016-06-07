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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Seraght
 */
public class CreatMultiAsset extends HttpServlet {

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
        int num = Integer.parseInt(request.getParameter("num"));

//        Create Computer Object.
        String assetYear = request.getParameter("assetYear");
        String subYear = assetYear.substring(3);
        int assetGet = Integer.parseInt(request.getParameter("assetGet"));
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        int count = 0;
        String number = "";

        double price = Double.parseDouble(request.getParameter("price"));
        String serial = request.getParameter("serial");
        Map properties = new HashMap();
        properties.put("model", request.getParameter("model"));
        properties.put("brand", request.getParameter("brand"));
        properties.put("description", request.getParameter("description"));
        ComputerSpec addSpec = new ComputerSpec(properties);
        String assetBuyDate = request.getParameter("assetBuyDate");

        for (int i = 0; i < num; i++) {

            List<Computer> c = Asset.primaryKeyFilter(subYear, assetGet, typeID);
            if (c != null) {
                ListIterator cl = c.listIterator();
                count = 1;
                while (cl.hasNext()) {
                    count++;
                    cl.next();
                }
                number = String.valueOf(count);
                if (number.length() == 1) {
                    number = "00" + number;
                } else if (number.length() == 2) {
                    number = "0" + number;
                }
            }

            if (count == 0) {
                number = "001";
            }

            Computer addComputer = new Computer(subYear, assetGet, number, typeID, serial, price, addSpec, assetBuyDate);

//        Insert Computer.
            Asset in = new Asset();
            Boolean result = in.insertComputer(addComputer);
            if (result != false) {
                message += "การเพิ่มครุภัณฑ์หมายเลข " + subYear + "-" + assetGet + "-" + number + "-" + typeID + " ประสบความสำเร็จ<br>";

            } else {
                message += "ไม่สามารถเพิ่มครุภัณฑ์หมายเลข " + subYear + "-" + assetGet + "-" + number + "-" + typeID + " เข้าสู่ฐานข้อมูลได้<br>";
            }
        }
        target = "/back/add_multi_result.jsp";

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
