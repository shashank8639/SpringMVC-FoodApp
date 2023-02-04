<%@page import="java.util.ArrayList"%>
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

		<% int count=0; %>
		<table border="3">
			
			<tr>
				<th>S.no</th>
				<th>Food</th>
				<th>Cost</th>
				<th>quantity</th>
				<th>Total Amt</th>
				<th> </th>
			</tr>
			
			<% int value=0; %>
			<c:forEach items="${myitems }" var="item">
			
			<tr>
				<td><%=++count %></td>
				<td>${item.itemName }</td>
				<td>${item.price }</td>
				<td>${item.quantity }</td>
				<td>${item.totalCost }</td>
				<td> <a href="deleteItem?value=<%=value%>"><input type="submit" value="DELETE"> </a>    </td>
				
			</tr>
			<%value++; %>
			
			</c:forEach>
			
			</table>
			
			<br>
			<a href="next"> <input type="submit" value="next"> </a>

</body>
</html>