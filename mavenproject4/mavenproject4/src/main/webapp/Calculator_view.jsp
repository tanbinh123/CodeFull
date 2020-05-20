<%-- 
Document   : Calculator_view
Created on : Sep 20, 2019, 11:05:00 PM
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
        <h1>Calculator</h1>
        <form action="controller" method="post">
            <input type="text" name="txtSo1" value=""><br><br>
            <input type="text" name="txtSo2" value=""><br>
            <br>
            <input type="submit" name="action" value="+">
            <input type="submit" name="action" value="-">
            <input type="submit" name="action" value="*">
            <input type="submit" name="action" value="/">
        </form>
    </body>
</html>
