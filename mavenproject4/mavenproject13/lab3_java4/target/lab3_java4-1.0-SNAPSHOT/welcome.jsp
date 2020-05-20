<%-- 
Document   : welcome
Created on : Oct 1, 2019, 9:44:41 PM
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
        <font color="red"> welcom, ${sessionScope.USER}</font>
        <h1>Welcome to MVC</h1>
        <form action="Controller">
            Name <input type="text" name="txtSearch" value=""><br/>
            <input type="submit" value="Search" name="btAction"/>
        </form>
    </body>
</html>
