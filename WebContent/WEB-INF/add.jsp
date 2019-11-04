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
<table><tr>
		<td><form:label path="title" value="Enter Title here">Title(String):</form:label></td>
		<td><form:input path="title" value="Enter Title here"/>
		<form:errors path="title" value="Enter Title here"/></td>
		<br />
		</tr>
		<tr>
		<td><form:label path="description" value="Enter Description here">Description(String):</form:label></td>
		<td><form:input path="description" value="Enter Description here"/>
		<form:errors path="description" value="Enter Description here"/></td>
		</tr>
		<tr>
		<td><form:label path="releaseYear" value="2019">Release Year(Integer):</form:label></td>
		<td><form:input path="releaseYear" value="2019"/>
		<form:errors path="releaseYear" value="2019"/></td>
		</tr>
		<tr>
		<td><form:label path="language" >Language:</form:label></td>
		<td><form:radiobutton path="language" value="English" checked="checked"/>English
		<form:radiobutton path="language" value="Italian"/>Italian
		<form:radiobutton path="language" value="Japanese"/>Japanese
		<form:radiobutton path="language" value="Mandarin"/>Mandarin
		<form:radiobutton path="language" value="French"/>French
		<form:radiobutton path="language" value="German"/>German</td>
		<form:errors path="language" />
		</tr>
		<tr>
		<td><form:label path="rentDuration" value="3">Rent Duration(Integer):</form:label></td>
		<td><form:input path="rentDuration" value="3"/>
		<form:errors path="rentDuration" value="3"/></td>
		</tr>
		<tr>
		<td><form:label path="rentRate" value="1.99">Rent Rate(Double):</form:label></td>
		<td><form:input path="rentRate" value="1.99"/>
		<form:errors path="rentRate" value="1.99"/></td>
		</tr>
		<tr>
		<td><form:label path="length" value="120">Length(Integer):</form:label></td>
		<td><form:input path="length" value="120"/>
		<form:errors path="length" value="120"/></td>
		</tr>
		<tr>
		<td><form:label path="replaceCost" value="40.00">Replace Cost(Double):</form:label></td>
		<td><form:input path="replaceCost" value="40.00"/>
		<form:errors path="replaceCost" value="40.00"/></td>
		</tr>
		<tr>
		<td><form:label path="category" value="Action">category(String):</form:label></td>
		<td><form:input path="category" value="Action"/>
		<form:errors path="category" value="Action"/>
		</tr>
		<tr>
		<td><form:label path="rating" value="G">Rating:</form:label></td>
		<td><form:radiobutton path="rating" value="G" checked="checked"/>G
		<form:radiobutton path="rating" value="PG"/>PG 
		<form:radiobutton path="rating" value="PG13"/>PG-13
		<form:radiobutton path="rating" value="R"/>R
		<form:radiobutton path="rating" value="NC17"/>NC-17</td> 
		<form:errors path="rating"/>
		</tr>
		<tr>
		<td><form:label path="specialFeat" value="Behind the scenes">Special Features(String):</form:label></td>
		<td><form:input path="specialFeat" value="Behind the scenes"/>
		<form:errors path="specialFeat" value="Behind the scenes"/></td>
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