<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AddFilm</title>
</head>
<body>
<h2>Please enter film details</h2>
	<form:form action="addFilm.do" method="GET" modelAttribute="film">
		<form:label path="title">Title(String):</form:label>
		<form:input path="title" />
		<form:errors path="title" />
		<br />
		<form:label path="description">Description(String):</form:label>
		<form:input path="description" />
		<form:errors path="description" />
		<br />
		<form:label path="releaseYear">Release Year(Integer):</form:label>
		<form:input path="releaseYear" />
		<form:errors path="releaseYear" />
		<br />
		<form:label path="language">Language(String):</form:label>
		<form:input path="language" />
		<form:errors path="language" />
		<br />
		<form:label path="rentDuration">Rent Duration(Integer):</form:label>
		<form:input path="rentDuration" />
		<form:errors path="rentDuration" />
		<br />
		<form:label path="rentRate">Rent Rate(Double):</form:label>
		<form:input path="rentRate" />
		<form:errors path="rentRate" />
		<br />
		<form:label path="length">Length(Integer):</form:label>
		<form:input path="length" />
		<form:errors path="length" />
		<br />
		<form:label path="replaceCost">Replace Cost(Double):</form:label>
		<form:input path="replaceCost" />
		<form:errors path="replaceCost" />
		<br />
		<form:label path="rating">Rating(String):</form:label>
		<form:input path="rating" />
		<form:errors path="rating" />
		<br />
		<form:label path="specialFeat">Special Features(String):</form:label>
		<form:input path="specialFeat" />
		<form:errors path="specialFeat" />
		<input type="submit" value="Add Film" />
	</form:form>
</body>
</html>