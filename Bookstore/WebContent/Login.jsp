<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>
	<form action="LoginServlet" method="post">
		<div class="container">
			<h3 class="font-weight-bold">Sign in to Account</h3>
			<h3 class="alert alert-warning">${message}</h3>
			<div class="form-group">
				<label for="uname"><b>User Name</b></label> <input type="text"
					class="form-control" name="uname" required>
			</div>
			<div class="form-group">
				<label for="psw"><b>Password</b></label> <input type="password"
					class="form-control" name="psw" required>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Login">
				<label> <input type="checkbox" checked="checked"
					name="remember"> Remember me
				</label>
			</div>

			<div class="form-group">
				<button type="reset" class="btn btn-primary">Reset</button>
				<span>You do not have an Account <a href="register.jsp">Sign
						Up</a></span>
			</div>
		</div>
	</form>
</body>
</html>