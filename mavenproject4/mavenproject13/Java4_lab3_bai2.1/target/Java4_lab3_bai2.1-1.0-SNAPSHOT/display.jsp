<%-- 
Document   : display
Created on : Oct 2, 2019, 9:51:03 PM
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
        <%="This is a String" %><br>
        <%= application.getAttribute("MyName") %>
    </body>
</html>
