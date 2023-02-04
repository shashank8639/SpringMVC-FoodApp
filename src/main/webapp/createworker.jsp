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
		<%  Object obj=session.getAttribute("ownerid"); %>

	<form:form action="saveWorker" modelAttribute="workermodel">
	
	Name <form:input path="workerName"/> <br>
	Email <form:input path="email"/> <br>
	Password <form:input path="password"/> <br>
	
	Owner Id <input type="number" value="<%=obj %>" readonly="readonly"> <br>
	
	<input type="submit" >
	
	</form:form>

</body>
</html>