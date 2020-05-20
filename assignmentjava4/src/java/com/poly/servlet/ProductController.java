/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.servlet;

import com.poly.Util.RequestAction;
import com.poly.dao.ProductDAO;
import com.poly.models.Product;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
public class ProductController extends HttpServlet {
    
    private ProductDAO pDao;

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
        pDao = new ProductDAO();
        String _action = request.getParameter("_action");
        switch (_action) {
            case RequestAction.INSERT:
                add(request, response);
                break;
            case RequestAction.LOGIN:
                break;
            case RequestAction.UPDATE:
                update(request, response);
                break;
            case RequestAction.DELETE:
                delete(request, response);
                break;
            case RequestAction.BUY:
                buy(request, response);
                break;
            case RequestAction.DELETECART:
                deletecart(request, response);
                break;
        }
    }
    private void buy(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        
        String ten = request.getParameter("ten");
        float gia = Float.parseFloat(request.getParameter("gia"));
        String ghichu = request.getParameter("note");
        String image = request.getParameter("image");
        int idproduct = Integer.parseInt(request.getParameter("id"));
        
        product.setName(ten);
        product.setPrice(gia);
        product.setNote(ghichu);
        product.setImage(image);
        product.setId(idproduct);
        
        productDAO.buyproduct(product);
        response.sendRedirect("user-cart.jsp");
    }
    
    private void fill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        pDao.fillToProduct();
    }
    
    private void fillcart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        pDao.filltocart();
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SecurityException {
        String id = request.getParameter("iddelete");
        pDao.deleteProduct(Integer.parseInt(id));
        response.sendRedirect("show-product.jsp");
    }
    
    private void deletecart(HttpServletRequest request, HttpServletResponse response) throws IOException, SecurityException {
        String id = request.getParameter("iddelete");
        pDao.deletecart(Integer.parseInt(id));
        response.sendRedirect("user-cart.jsp");
    }
    
    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ProductDAO productDAO = new ProductDAO();
        Product product = new Product();
        
        String ten = request.getParameter("ten");
        float gia = Float.parseFloat(request.getParameter("gia"));
        String ghichu = request.getParameter("note");
        String image = request.getParameter("image");
        int idcategory_id = Integer.parseInt(request.getParameter("idcategory_id"));
        
        product.setName(ten);
        product.setPrice(gia);
        product.setNote(ghichu);
        product.setImage(image);
        product.setidcategory_id(idcategory_id);
        
        productDAO.insertproduct(product);
        response.sendRedirect("show-product.jsp");
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        float price = Float.parseFloat(request.getParameter("price"));
        String note = request.getParameter("note");
        String image = request.getParameter("image");
        int idcategory_id = Integer.parseInt(request.getParameter("idcategory_id"));
        
        Product product = new Product(id, name, price, note, image, idcategory_id);
        if (pDao.UpdateProduct(product)) {
            request.getSession().setAttribute("message", "Cập nhật thành công");
            request.getSession().setAttribute("status", "success");
        } else {
            request.getSession().setAttribute("message", "cập nhật thất bại");
            request.getSession().setAttribute("status", "danger");
        }
        response.sendRedirect("update-product.jsp");
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
