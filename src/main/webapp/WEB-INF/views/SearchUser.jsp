<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Search users</h2>

	<form action="searchuser" method="post">
		<div class="mb-3">
			<label for="firstName" class="form-label">First Name</label> <input
				type="text" class="form-control" id="firstName" name="firstName"
				required>
		</div>
		<br>
		<div class="mb-3">
			<label for="lastName" class="form-label">Last Name</label> <input
				type="text" class="form-control" id="lastName" name="lastName"
				required>
		</div>
		<br>
		<div class="d-grid">
			<button type="submit" class="btn btn-success btn-lg">Search
			</button>
		</div>
	</form>

	<br>
	<br>

	<table border="1">
		<thead>
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
					<td><a href="edituser?userId=${u.userId}"
						class="btn btn-primary">Edit</a> <a
						href="deleteuser?id=${u.userId}" class="btn btn-danger btn-sm">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>