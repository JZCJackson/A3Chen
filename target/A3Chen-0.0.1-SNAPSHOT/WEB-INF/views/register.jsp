<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<!-- Navbar -->
	<%@include file="navbar.jsp"%>

	<div class="container mt-3" style="width: 75%">
		<h1>Register User</h1>
		<form class="row g-3" action="${pageContext.request.contextPath}/register" method="POST">
			<div class="col-md-12">
				<label for="name" class="form-label">Name</label> <input
					type="text" class="form-control" id="name" name="name">
			</div>			
			<div class="col-md-12">
				<label for="email" class="form-label">Email</label> <input
					type="email" class="form-control" id="email" name="email">
			</div>
			<div class="col-md-12">
				<label for="gender" class="form-label">Gender</label> <select
					name="gender" id="gender" class="form-select mb-3">
					<option value="Male">Male</option>
					<option value="Female">Female</option>
					<option value="Other">Other</option>
				</select>
			</div>
				<div class="col-md-12">
			<label for="password" class="form-label">Password</label> <input
				type="password" class="form-control" id="password" name="password">
		</div>
		<div class="col-md-4">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
</div>
		</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
</html>
