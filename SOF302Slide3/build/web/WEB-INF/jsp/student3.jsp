<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Spring MVC - Databinding</title>
        <base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
    <h2>Quản lý sinh viên</h2>
   
    <form:form action="student3.html" modelAttribute="student">
        <div>Mã SV</div>
        <form:input path="masv" readonly="true"/>
        <div>Họ và tên</div>
        <form:input path="name"/>
       
        <div>Điểm</div>
        <form:input path="mark"/>

        <div>Chuyên ngành</div>
        <form:select path="major">
                <form:option value="APP">Ứng dụng phần mềm</form:option>
                <form:option value="WEB">Thiết kế trang web</form:option>
        </form:select>
                
        <div>
            <button name="btnInsert">Thêm</button>
            <button name="btnUpdate">Cập nhật</button>         
        </div>
    </form:form>
    <br>            
    
        
    <table border="1">
        <tr>
            <td>Masv</td>
            <td>Name</td>
            <td>Mark</td>
            <td>Major</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="rows" items="${listStudent}">
            <form action="student3/delete.html">
            <tr>
                <td>${rows.masv}</td>
                <td>${rows.name}</td>
                <td>${rows.mark}</td>
                <td>${rows.major}</td>
                <c:url var="edit" value="student3/edit.html">
                    <c:param name="txtMasv" value="${rows.masv}"/>
                    <c:param name="txtName" value="${rows.name}"/>
                    <c:param name="txtMark" value="${rows.mark}"/>
                    <c:param name="txtMajor" value="${rows.major}"/>
                </c:url>
                <td><a href="${edit}">Edit</a></td>
                <td>
                    <input type="hidden" name="txtMasv" value="${rows.masv}"/>
                    <input type="submit" name="action" value="Delete"/>
                </td>
            </tr>
            </form>
        </c:forEach>    
    </table>
</body>
</html>
