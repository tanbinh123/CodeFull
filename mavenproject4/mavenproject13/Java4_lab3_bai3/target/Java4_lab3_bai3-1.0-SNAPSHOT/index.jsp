<%-- 
Document   : index.jsp
Created on : Oct 2, 2019, 9:56:16 PM
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
        <%!
        int sum(int num1, int num2, int num3){
        return num1+num2+num3;
        }
        %>
        <%= "Result is: " + sum(10,40,50) %> 
    </body>
</html>
