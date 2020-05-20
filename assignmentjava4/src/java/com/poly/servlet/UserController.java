/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.servlet;

import com.poly.Util.RequestAction;
import com.poly.dao.UserDAO;
import com.poly.models.User;
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
public class UserController extends HttpServlet {

    private UserDAO uDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        uDao = new UserDAO();
        String _action = request.getParameter("_action");
        switch (_action) {
            case RequestAction.INSERT:
                insert(request, response);
                break;
            case RequestAction.LOGIN:
                login(request, response);
                break;
            case RequestAction.UPDATE:
                update(request, response);
                break;
            case RequestAction.DELETE:
                delete(request, response);
                break;

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = uDao.checkLogin(username, password);
        if (user == null) {
            String error = "Tài khoản hoặc mật khẩu không đúng";
            request.getSession().setAttribute("ERROR", error);
            request.getSession().setAttribute("username", username);
            response.sendRedirect("login.jsp");
            return;
        } else if (user.getRole() == 0) {
            request.getSession().setAttribute("ADMIN", user);
            response.sendRedirect("index.jsp");
            return;
        } else if (user.getRole() == 1) {
            request.getSession().setAttribute("USER", user);
            response.sendRedirect("view-cart.jsp");
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserDAO userDAO = new UserDAO();
        User user = new User();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int role = Integer.parseInt(request.getParameter("role"));

        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setRole(role);

        userDAO.insertUser(user);
        response.sendRedirect("list-user.jsp");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int role = Integer.parseInt(request.getParameter("role"));
        User user = new User(id, username, password, fullname, phone, email, role);
        if (uDao.UpdateUser(user)) {
            request.getSession().setAttribute("message", "Cập nhật thành công");
            request.getSession().setAttribute("status", "success");
        } else {
            request.getSession().setAttribute("message", "cập nhật thất bại");
            request.getSession().setAttribute("status", "danger");
        }
        response.sendRedirect("update-user.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("iddelete");
        uDao.DeleteUser(username);
        response.sendRedirect("list-user.jsp");
    }

    private void fill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        uDao.fillToTable();
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
