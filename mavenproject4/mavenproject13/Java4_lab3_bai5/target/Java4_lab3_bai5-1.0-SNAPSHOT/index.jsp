<%-- 
Document   : index
Created on : Oct 2, 2019, 9:57:23 PM
Author     : thanh
--%>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Random rd = new Random();
        int num = rd.nextInt();%>
        <% if (num > 5) { %>
        <H3> hi </H3>
        <%} else {%>
        <h3> num value should not be less than 6 </h3>
        <% } %>
    </body>
</html>
