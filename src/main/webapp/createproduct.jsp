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
			<%  Object id=session.getAttribute("ownerid"); %>

			<form:form action="saveProduct" modelAttribute="productmodel" >
		
		FoodName <form:input path="foodName"/> <br>
		
		Description <form:input path="description"/> <br>
		cost <form:input path="cost"/> <br>
		FoodType <form:input path="foodType" /> <br>
		
		Owner Id <input type="text" readonly="readonly" value="<%= id%>">
		
		<input type="submit">
		
		</form:form>

</body>
</html>