<%-- 
Document   : Calculator
Created on : Oct 9, 2019, 8:44:11 PM
Author     : thanh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
        </style>
    </head>
    <body>
        <h1>Calculator</h1>
        <form>
            So1: <input name="txtNum1" value="${param.txtNum1}"/><br/>
            So2: <input name="txtNum2" value="${param.txtNum2}"/><br/>
            <input type="submit" value="Cong">
            <h1>Tổng 2 số: ${param.txtNum1 + param.txtNum2}</h1>
        </form>
    </body>
</html>
