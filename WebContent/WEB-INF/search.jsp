<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>
</head>
<body>
	<form:form action="displayfullinfo.do" method="GET" modelAttribute="film">
		<form:label path="keyword">Keyword:</form:label>
		<form:input path="keyword" />
		<form:errors path="keyword" />
		<input type="submit" value="Search Keyword" />
		</form:form>
		<br />
			<form:form action="displayfullinfo.do" method="GET" modelAttribute="film">
		<form:label path="id">ID:</form:label>
		<form:input path="id" />
		<form:errors path="id" />
		<input type="submit" value="Search Id" />
	</form:form>
</body>
</html>