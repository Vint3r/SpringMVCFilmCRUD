<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Films</title>
</head>
<body>
	<h1>${film.title}</h1>
	<table>
		<tr>
			<td>Film Title</td>
			<td>${film.title}</td>
		</tr>
		<tr>
			<td>Film Description</td>
			<td>${film.description}</td>
		</tr>
		<tr>
			<td>Film Category</td>
			<td>${film.category}</td>
		</tr>
		<tr>
			<td>Film Release Year</td>
			<td>${film.releaseYear}</td>
		</tr>
		<tr>
			<td>Film Language</td>
			<td>${film.language}</td>
		</tr>
		<tr>
			<td>Film Rent Duration</td>
			<td>${film.rentDuration}</td>
		</tr>
		<tr>
			<td>Film Rent Rate</td>
			<td>${film.rentRate}</td>
		</tr>
		<tr>
			<td>Film Length</td>
			<td>${film.length}</td>
		</tr>
		<tr>
			<td>Film Replacement Cost</td>
			<td>${film.replaceCost}</td>
		</tr>
		<tr>
			<td>Film Rating</td>
			<td>${film.rating}</td>
		</tr>
		<tr>
			<td>Film Special Features</td>
			<td>${film.specialFeat}</td>
		</tr>
	</table>
	<div class="container">
		<table>
			<c:forEach var="actor" items="${film.actors}">
				<tr>
					<td>Film Actor</td>
					<td>${actor.firstName }</td>
					<td>${actor.lastName }</td>
				</tr>
			</c:forEach>

		</table>
			<a href="index.html" class="btn btn-secondary" role="button">Back
				to Home</a> <br>
			<form:form action="delete.do" method="GET" modelAttribute="film">
				<form:label path="id">ID:</form:label>
				<form:input path="id" />
				<form:errors path="id" />
				<input type="submit" value="Delete ID" />
			</form:form>
		<form:form action="addFilm.do" method="GET" modelAttribute="film">
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
		<td><input type="submit" value="Update Film" /></td>
		</tr>
		</table>
	</form:form>
	</div>
</body>
</html>