<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">Edit</h2>
	<form action="UpdateServlet" method="get">
	<comment> Hidden is used to hide the object in the form</comment>
	<input type="hidden" name="id" value="${book.id}">
		<table border="1" align="center">
			<tr>
				<th>Title</th>
				<th><input type="text" name="title" value="${book.title}">
			</tr>
			<tr>
				<th>Author</th>
				<th><input type="text" name="author" value="${book.author}">
			</tr>
			<tr>
				<th>Price</th>
				<th><input type="text" name="price" value="${book.price}">
			</tr>
			<tr>
				<th colspan="2"><input type="submit" name="save" value="Update">
			</tr>
		</table>
	</form>
</body>
</html>