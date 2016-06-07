/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.servlet;

import com.asset.model.ComputerSpec;
import com.asset.model.Asset;
import com.asset.model.Computer;
import java.io.IOException;
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
public class CreateAsset extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String message = "";
        String target = null;

//        Create Computer Object.
        String assetYear = request.getParameter("assetYear");
        String subYear = assetYear.substring(3);
        int assetGet = Integer.parseInt(request.getParameter("assetGet"));
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        int count = 0;
        String number = "";

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

        double price = Double.parseDouble(request.getParameter("price"));
        String serial = request.getParameter("serial");
        Map properties = new HashMap();
        properties.put("model", request.getParameter("model"));
        properties.put("brand", request.getParameter("brand"));
        properties.put("description", request.getParameter("description"));
        ComputerSpec addSpec = new ComputerSpec(properties);
        String assetBuyDate = request.getParameter("assetBuyDate");
        Computer addComputer = new Computer(subYear, assetGet, number, typeID, serial, price, addSpec,assetBuyDate);

//        Insert Computer.
        Asset in = new Asset();
        Boolean result = in.insertComputer(addComputer);
        if (result != false) {
            message = "การเพิ่มครุภัณฑ์หมายเลข " + subYear + "-" + assetGet + "-" + number + "-" + typeID + " ประสบความสำเร็จ";

        } else {
            message = "ไม่สามารถเพิ่มครุภัณฑ์หมายเลข " + subYear + "-" + assetGet + "-" + number + "-" + typeID + " เข้าสู่ฐานข้อมูลได้";
        }
        target = "/back/add_result.jsp";

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(target).forward(request, response);
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
