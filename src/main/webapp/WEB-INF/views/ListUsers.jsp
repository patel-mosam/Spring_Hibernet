<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Users here</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h2 class="text-center mb-4">Users List</h2>
	<table class="table table-bordered table-striped">
		<thead class="table-dark">
			<tr>
				<th>UserId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userId}</td>
				<td>${u.firstName}</td>
				<td>${u.lastName}</td>
				<td>
					<button class="btn btn-warning btn-sm">Edit</button>
					<a href="deleteuser?id=${u.userId}" class="btn btn-danger btn-sm">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
