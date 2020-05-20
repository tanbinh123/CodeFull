package Sample.Controller;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author thanh
 */
public class SearchAccount extends HttpServlet {

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
        
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>SearchAccount</title></head>");
        out.println("<body><h1>Kết quả tra điện thoại theo yêu cầu của bạn:</h1>");
        out.println("<table border=1 cellPadding=1 cellSpacing=1>");
        String tentbao = request.getParameter("txtThuebao");

        String newSQL = "SELECT * FROM CUSTOMER";
        if (tentbao != null && tentbao.length() != 0) {
            newSQL = newSQL + " where TenThuebao like N'%" + tentbao + "%'";
        }
        String conStr = "jdbc:sqlserver://localhost:1433;databaseName=QLDienThoai";

        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(conStr, "sa", "songlong");
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(newSQL);
            out.println("<tr><th>Số thứ tự</th><th>Tên thuê bao</th><th>Số điện thoại</th><th>Địa chỉ</th></tr>\n");
            if (rs != null) {
                for (int i = 1; rs.next(); i++) {
                    out.println("<tr>" + "<td>" + i + "</td>" + "<td>" + rs.getString(2) + "</td>"
                            + "<td>" + rs.getString(3) + "</td>"
                            + "<td>" + rs.getString(4) + "</td></tr>\n");
                }
            }
            out.println("</table>");
            rs.close();
            stmt.close();
            con.close();
            out.write("<br><a href='index.jsp'>back</a>");
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
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
