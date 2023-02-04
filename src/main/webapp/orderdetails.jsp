<%@page import="com.hotel.mvc.springmvc_hotelapp.util.BillService"%>
<%@page import="com.hotel.mvc.springmvc_hotelapp.dto.FoodItem"%>
<%@page import="java.util.ArrayList"%>
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

			<table border="3">
				<tr>
		
					<th>Worker Name</th>
					<th> To Customer</th>
					<th>Order Date</th>
					<th> time </th>
				</tr>
				<tr>
					<form:form modelAttribute="ordermodel">
					
					<td> <form:input path="workerName" readonly="true"/>  </td>
					<td> <form:input path="customerName" readonly="true"/> </td>
					<td> <form:input path="orderDate" readonly="true"/> </td>
					<td> <form:input path="time" readonly="true"/> </td>
					
					</form:form>
					
				</tr>
			
			</table>
			
			<br>
			
			<%   ArrayList<FoodItem> items=(ArrayList<FoodItem>)session.getAttribute("allitems");
			
				BillService service=new BillService();
			
			      double bill=service.totalBill(items);                          %>
			
			
			<table border="3">
				<tr>
		
					<th>FoodName</th>
					<th>quantity</th>
					<th>total Cost</th>
				</tr>
				<% for(FoodItem item : items) { %>
			
				<tr>
					<td><%=item.getItemName() %></td>
					<td><%=item.getQuantity() %></td>
					<td><%=item.getTotalCost() %></td>
				</tr>
				
				<%} %>
				
				<tr>
						<td colspan="2">Total Bill</td>
						<td colspan="2"> <%=bill %>  </td>
				</tr>
			
			</table>
			
			
			<center> <a href="confirm"> <input type="submit" value="confirm Order"></a> </center>
			

</body>
</html>