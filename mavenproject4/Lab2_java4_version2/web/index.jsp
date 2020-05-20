<%-- 
Document   : index
Created on : Sep 24, 2019, 10:18:17 AM
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
        <h1>Danh bạ điện thoại</h1>
        <form action="SearchAccount" method="post">
            Nhập tên thuê bao: <input type="text" name="txtThuebao" value=""><br/>
            Nhập số điện thoại: <input type="text" name="txtSoDT" value=""><br/>
            Địa chỉ: <input type="text" name="txtDiaChi" value=""><br/>
            <input type="submit" name="Submit" value="Tra cứu">
        </form>
    </body>
</html>
