<%-- 
    Document   : logout
    Created on : Oct 13, 2019, 10:22:03 PM
    Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getSession().removeAttribute("USER");
    response.sendRedirect("login.jsp");
%>
