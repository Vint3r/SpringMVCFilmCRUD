<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Stock List</title>
</head>
<body>
	<div class="container">
		<%-- Iterate through the Stocks and print all data in a table row. --%>
		<table>
		<c:forEach var="stock" items="${stockList}">
		<tr>
		<td>${stock.name }</td>
		<td>${stock.symbol }</td>
		<td>${stock.price }</td>
		
		</tr>
		</c:forEach>
		
		</table>
		<p>
			<a href="index.html" class="btn btn-secondary" role="button">Back to Home</a>
		</p>
	</div>
</body>
</html>