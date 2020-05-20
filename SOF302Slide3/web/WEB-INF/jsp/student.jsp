<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Spring MVC - Databinding</title>
</head>
<body>
	<h2>Quản lý sinh viên</h2>
	<form:form action="update.html" modelAttribute="student">
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
                    <button>Update</button>
		</div>
	</form:form>
</body>
</html>
