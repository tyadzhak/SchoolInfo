<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>School Manager</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>

	<jsp:include page="../pages/fragments/header.jsp"></jsp:include>

	<div class="container">

		<h2>Schools</h2>
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Postal Code</th>
				</tr>
				<c:forEach items="${schoolList}" var="school">
					<tr>
						<td>${school.id}</td>
						<td><a
							href="<spring:url 
							value="/school/edit/${school.id}"/>">${school.name}</a></td>
						<td>${school.postalCode}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<button type="button" class="btn btn-default"
			onclick="location.href='<spring:url value="/school/create"/>'">Add</button>
	</div>



</body>
</html>