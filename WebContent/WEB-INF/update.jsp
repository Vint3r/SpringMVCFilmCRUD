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
	<form:form action="updateFilm.do" method="GET" modelAttribute="film">
<table><tr>
		<td><form:label path="title">Title(String):</form:label></td>
		<td><form:input path="title" />
		<form:errors path="title" /></td>
		<br />
		</tr>
		<tr>
		<td><form:label path="description">Description(String):</form:label></td>
		<td><form:input path="description" />
		<form:errors path="description" /></td>
		</tr>
		<tr>
		<td><form:label path="releaseYear">Release Year(Integer):</form:label></td>
		<td><form:input path="releaseYear" />
		<form:errors path="releaseYear" /></td>
		</tr>
		<tr>
		<td><form:label path="language">Language(String):</form:label></td>
		<td><form:input path="language" />
		<form:errors path="language" /></td>
		</tr>
		<tr>
		<td><form:label path="rentDuration">Rent Duration(Integer):</form:label></td>
		<td><form:input path="rentDuration" />
		<form:errors path="rentDuration" /></td>
		</tr>
		<tr>
		<td><form:label path="rentRate">Rent Rate(Double):</form:label></td>
		<td><form:input path="rentRate" />
		<form:errors path="rentRate" /></td>
		</tr>
		<tr>
		<td><form:label path="length">Length(Integer):</form:label></td>
		<td><form:input path="length" />
		<form:errors path="length" /></td>
		</tr>
		<tr>
		<td><form:label path="replaceCost">Replace Cost(Double):</form:label></td>
		<td><form:input path="replaceCost" />
		<form:errors path="replaceCost" /></td>
		</tr>
		<tr>
		<td><form:label path="category">category(String):</form:label></td>
		<td><form:input path="category" />
		<form:errors path="category" /></td>
		</tr>
		<tr>
		<td><form:label path="rating">Rating:</form:label></td>
		<td><form:radiobutton path="rating" value="G"/>G
		<form:radiobutton path="rating" value="PG"/>PG 
		<form:radiobutton path="rating" value="PG-13"/>PG-13
		<form:radiobutton path="rating" value="R"/>R
		<form:radiobutton path="rating" value="NC-17"/>NC-17</td> 
		</tr>
		<tr>
		<td><form:label path="specialFeat">Special Features(String):</form:label></td>
		<td><form:input path="specialFeat" />
		<form:errors path="specialFeat" /></td>
		</tr>
		<tr>
		<td><input type="submit" value="Add Film" /></td>
		</tr>
		</table>
	</form:form>
	<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
</body>
</html>