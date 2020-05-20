<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Load data</h1>
    <sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                       url="jdbc:sqlserver://localhost:1433;databaseName=Java4_Lab5"
                       user="sa" password="songlong"
                       var="con"/>
    <sql:query dataSource="${con}" var="rs">
        select * from USERS
    </sql:query>
    <table border="1">
        <tr>
            <td>No.</td><td>Username</td><td>Password</td><td>Lastname</td>
        </tr>
        <c:set var="count" value="0"/>
        <c:forEach var="dong" items="${rs.rows}">
            <tr>
            <c:set var="count" value="${count+1}"/>
            <td>${count}</td>
            <td>${dong.username}</td>
            <td>${dong.password}</td>
            <td>${dong.lasname}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
