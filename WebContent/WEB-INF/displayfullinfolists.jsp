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
	<c:forEach var="film" items="${films}">
		<h1>${film.title}</h1>
		<table>
			<tr>
				<td>Film Id</td>
				<td>${film.id}</td>
			</tr>
			<tr>
				<td>Film Title</td>
				<td>${film.title}</td>
			</tr>
			<tr>
				<td>Film Description</td>
				<td>${film.description}</td>
			</tr>
			<tr>
				<td>Film Release Year</td>
				<td>${film.releaseYear}</td>
			</tr>
			<tr>
				<td>Film Category</td>
				<td>${film.category}</td>
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
		to Home</a>
	<br>
	<form:form action="delete.do" method="GET" modelAttribute="film">
		<form:label path="id">ID:</form:label>
		<form:hidden path="id" />
		<form:errors path="id" />
		<input type="submit" value="Delete ID" />
	</form:form>
	<form:form action="update.do" method="GET" modelAttribute="film">
<table><tr>
		<td><form:label path="title" value="${film.title}">Title(String):</form:label></td>
		<td><form:input path="title" value="${film.title}"/>
		<form:errors path="title" value="${film.title}" /></td>
		<br />
		</tr>
		<tr>
		<td><form:label path="description" value="${film.description}">Description(String):</form:label></td>
		<td><form:input path="description" value="${film.description}"/>
		<form:errors path="description" value="${film.description}"/></td>
		</tr>
		<tr>
		<td><form:label path="releaseYear" value="${film.releaseYear}">Release Year(Integer):</form:label></td>
		<td><form:input path="releaseYear" value="${film.releaseYear}"/>
		<form:errors path="releaseYear" value="${film.releaseYear}"/></td>
		</tr>
		<tr>
		<td><form:label path="language">Language:</form:label></td>
		<td><form:radiobutton path="language" value="English"/>English
		<form:radiobutton path="language" value="Italian"/>Italian
		<form:radiobutton path="language" value="Japanese"/>Japanese
		<form:radiobutton path="language" value="Mandarin"/>Mandarin
		<form:radiobutton path="language" value="French"/>French
		<form:radiobutton path="language" value="German"/></td>
		<form:radiobutton path="language" value="${film.language}"/>
		</tr>
		<tr>
		<td><form:label path="rentDuration" value="${film.rentDuration}">Rent Duration(Integer):</form:label></td>
		<td><form:input path="rentDuration" value="${film.rentDuration}"/>
		<form:errors path="rentDuration" value="${film.rentDuration}"/></td>
		</tr>
		<tr>
		<td><form:label path="rentRate" value="${film.rentRate}">Rent Rate(Double):</form:label></td>
		<td><form:input path="rentRate" value="${film.rentRate}"/>
		<form:errors path="rentRate" value="${film.rentRate}"/></td>
		</tr>
		<tr>
		<td><form:label path="length" value="${film.length}">Length(Integer):</form:label></td>
		<td><form:input path="length" value="${film.length}"/>
		<form:errors path="length" value="${film.length}"/></td>
		</tr>
		<tr>
		<td><form:label path="replaceCost" value="${film.replaceCost}">Replace Cost(Double):</form:label></td>
		<td><form:input path="replaceCost" value="${film.replaceCost}"/>
		<form:errors path="replaceCost" value="${film.replaceCost}"/></td>
		</tr>
		<tr>
		<td><form:label path="category" value="${film.category}">category(String):</form:label></td>
		<td><form:input path="category" value="${film.category}"/>
		<form:errors path="category" value="${film.category}"/></td>
		</tr>
		<tr>
		<td><form:label path="rating" value="${film.rating}">Rating:</form:label></td>
		<td><form:radiobutton path="rating" value="G"/>G
		<form:radiobutton path="rating" value="PG"/>PG 
		<form:radiobutton path="rating" value="PG-13"/>PG13
		<form:radiobutton path="rating" value="R"/>R
		<form:radiobutton path="rating" value="NC-17"/>NC17</td> 
		</tr>
		<tr>
		<td><form:label path="specialFeat" value="${film.specialFeat}">Special Features(String):</form:label></td>
		<td><form:input path="specialFeat" value="${film.specialFeat}"/>
		<form:errors path="specialFeat" value="${film.specialFeat}"/></td>
		</tr>
		<tr>
		<td><input type="submit" value="Update Film" /></td>
		</tr>
		</table>
		<br>
	</form:form>
	</c:forEach>
	
	</div>
</body>
</html>