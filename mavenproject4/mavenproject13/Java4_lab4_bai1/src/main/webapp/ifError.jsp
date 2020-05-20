<%-- 
Document   : ifError
Created on : Oct 4, 2019, 3:25:03 PM
Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page errorPage="myerrorpage.jsp" %>
        <%= 100/0 %> 
    </body>
</html>
