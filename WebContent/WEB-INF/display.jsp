<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>
	<h1>${user.firstName } ${user.lastName}</h1>
	<h3>${user.email}</h3>
	<table>
		<tr>
			<td>First Name:</td>
			<td>${user.firstName}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${user.lastName}</td>
		</tr>
		<tr>
			<td>Age:</td>
			<td>${user.age}</td>
		</tr>
	</table>
</body>
</html>