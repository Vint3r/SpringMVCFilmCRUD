<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<tr>
				<td>Film Category</td>
				<td>${film.category}</td>
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
	<p>

		<a href="index.html" class="btn btn-secondary" role="button">Back
			to Home</a>
			<br />
				<form action="delete.do" method="GET">
		<input type="submit" value="Delete Button" />
	</form>
	</p>
	</div>
</body>
</html>