
<%-- 
Document   : showcart
Created on : Sep 25, 2019, 5:19:43 PM
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
        <h1>Your Shopping Cart</h1>
        <c:set var="shop" value="${sessionScope.SHOP}" />
        <c:if test="${not empty shop}">
            <table border="1">
                <thead>
                    <tr>
                        <td>No.</td>
                        <td>Code</td>
                        <td>Name</td>
                        <td>Price</td>
                        <td>Quantity</td>
                        <td>Action</td>
                    </tr>
                </thead>
                <tbody>
                <form action="ControllerCartBean">
                    <c:set var="count" value="0"/>
                    <c:forEach var="rows" items="${shop}">
                        <c:set var="count" value="${count + 1}" />
                        <tr>
                            <td>${count}</td>
                            <td>${rows.value.sanpham.code}</td>
                            <td>${rows.value.sanpham.name}</td>
                            <td>${rows.value.sanpham.price}</td>
                            <td>${rows.value.quantity}</td>
                            <td><input type="checkbox" name="rmv"
                                       value="${rows.value.sanpham.code}"/></td>
                        </tr>
                    </c:forEach>
                    <tr>
                    <c:url var="add" value="ControllerCartBean">
                        <c:param name="action" value="AddMore"/>
                    </c:url>
                    <td colspan="2"><a href="${add}">Add more</a></td>
                    <td><input type="submit" value="Remove" name="action"/></td>
                    </tr>
                </form>
                </tbody>
            </table>
        </c:if>
    </body>
</html>
