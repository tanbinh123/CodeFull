<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Spring MVC - Databinding</title>
	<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
	<h2>Quản lý sinh viên</h2>
	<form:form action="student2/update.html" modelAttribute="student">
		<div>Họ và tên</div>
		<form:input path="name"/>
		
		<div>Điểm</div>
		<form:input path="mark"/>
		
                <div>Chuyên ngành</div>
                <form:select path="major" items="${majors}" 

                itemLabel="name" itemValue="id" /> 
   
           
                <div>Chuyen nganh</div>
                <form:radiobuttons path="major" items="${majors}"          
             itemValue="id" itemLabel="name"/>
        
		<div>
			<button>Update</button>
		</div>
	</form:form>
                
</body>
</html>
