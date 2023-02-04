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
			<center> <h1>Customer Details</h1> </center>

			<form:form action="saveCustomer" modelAttribute="customermodel" >
		
		Name <form:input path="customer"/><br>
		Mobile Number <form:input path="mobileNo"/> <br>
		City <form:input path="city"/><br>
		
		<input type="submit">
		
		</form:form>


</body>
</html>