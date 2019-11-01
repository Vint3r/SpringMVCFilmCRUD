<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form:form action="login.do" method="POST" modelAttribute="film">

		<form:label path="keyword">Keyword:</form:label>
		<form:input path="email" />
		<form:errors path="email" />
		<input type="submit" value="Login" />
		</form:form>
		<br />
			<form:form action="login.do" method="POST" modelAttribute="film">
		<form:label path="id">ID:</form:label>
		<form:input path="password" />
		<form:errors path="password" />
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>