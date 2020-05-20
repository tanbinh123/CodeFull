<%-- 
Document   : EL_Expression
Created on : Oct 9, 2019, 8:35:28 PM
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
        <h1>El Expression</h1>
        <table>
            <tr>
                <td>Concept</td>
                <td>Expression</td>
                <td>Result</td>
            </tr>
            <tr>
                <td>Cộng</td>
                <td>${"${"}5+5}</td>
                <td>${5+5}</td>
            </tr>
            <tr>
                <td>Trừ</td>
                <td>${"${"}5-5}</td>
                <td>${5-5}</td>
            </tr>
            <tr>
                <td>Nhân</td>
                <td>${"${"}5*5}</td>
                <td>${5*5}</td>
            </tr>
            <tr>
                <td>Chia</td>
                <td>${"${"}5/5}</td>
                <td>${5/5}</td>
            </tr>
        </table>
    </body>
</html>
