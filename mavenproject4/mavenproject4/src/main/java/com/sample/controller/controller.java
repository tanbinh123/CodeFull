/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.controller;

import com.sample.model.Model;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
public class controller extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try{
            String action = request.getParameter("action");
            String a = request.getParameter("txtSo1");
            String b = request.getParameter("txtSo2");
            double so1 = Double.parseDouble(a);
            double so2 = Double.parseDouble(b);
            
            if(action.equals("+")){
                Model md = new Model();
                out.write(so1 + " + " + so2 + " = " + md.Addition(so1, so2));
            }else if(action.equals("-")){
                Model md = new Model();
                out.write(so1 + " - " + so2 + " = " + md.Subtraction(so1, so2));
            }else if(action.equals("*")){
                Model md = new Model();
                out.write(so1 + " * " + so2 + " = " + md.Multiplication(so1, so2));
            }else if(action.equals("/")){
                Model md = new Model();
                out.write(so1 + " / " + so2 + " = " + md.Division(so1, so2));
            }
            out.write("<br><a href='Calculator_view.jsp'>back</a>");
            
        }catch(Exception e){
            e.printStackTrace();
        }
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
