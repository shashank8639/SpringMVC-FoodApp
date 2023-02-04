<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<center> <h1>Order is saved </h1> </center>

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
			<a href="refresh"><input type="submit" value="Back to home"> </a>
			

</body>
</html>