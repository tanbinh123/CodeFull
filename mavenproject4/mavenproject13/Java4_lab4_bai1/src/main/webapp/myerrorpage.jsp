<%-- 
Document   : myerrorpage
Created on : Oct 4, 2019, 3:26:38 PM
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
        <%@ page isErrorPage="true" %>
        Sorry an exception occured!<br/>
        The exception is: <%= exception %> 
    </body>
</html>
