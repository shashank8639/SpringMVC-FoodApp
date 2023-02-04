<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form:form action="toOrder"  method="post" modelAttribute="item">
		
		Food <form:input path="itemName" readonly="true"/> <br>
		quantity <form:input path="quantity"/> <br>
		Price <form:input path="price" readonly="true"/> <br>
		
		<input type="submit">
		</form:form>

</body>
</html>