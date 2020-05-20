<%-- 
Document   : newjsp
Created on : Oct 1, 2019, 12:27:02 PM
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
        <h1>Login page</h1>
        <form action="Controller" method="post" >
            Username <input type="text" name="txtUsername" value=""><br/>
            Password <input type="password" name="txtPass" value=""><br/>
            <input type="submit" value="Login" name="btAction"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
