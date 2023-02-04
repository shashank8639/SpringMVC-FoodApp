<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<table border="3">
			
			<tr>
				<th>S.no</th>
				<th>Food</th>
				<th>Description</th>
				<th>Cost</th>
				<th>FoodType</th>
				<th></th>
			</tr>
			
			<c:forEach items="${allproducts }" var="product">
			
			<tr>
				<td>${product.id }</td>
				<td>${product.foodName }</td>
				<td>${product.description }</td>
				<td>${product.cost }</td>
				<td>${product.foodType }</td>
				<td>   <a href="addItem?id=${product.id }"> <input type="submit" value="add">  </td>
			</tr>
			
			
			</c:forEach>
			
			
			</table>
			<br>
			<center> <a href="cart"> <input type="submit" value="CART"> </a> </center>
			

</body>
</html>