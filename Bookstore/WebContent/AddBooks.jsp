<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book Form</title>
<style type="text/css">
table tr th {
	width: 100;
	padding: 10;
}
</style>
</head>
<body>
<Center>
	<h1 align="center">Books Management</h1>
	<a href="AddBook.jsp" style="color: blue;">Add New Book</a> 
		&nbsp; &nbsp; &nbsp;
	<a href="ListServlet" style="color: blue;">List All Books</a>
	<br>
	<br>
	<h2>Add New Book</h2>
	<form action="AddBookServlet" method="get">
		<table border="1" align="center">
			<tr>
				<th>Title</th>
				<th><input type="text" name="title">
			</tr>
			<tr>
				<th>Author</th>
				<th><input type="text" name="author">
			</tr>
			<tr>
				<th>Price</th>
				<th><input type="text" name="price">
			</tr>
			<tr>
				<th colspan="2"><input type="submit" name="save" value="save">
			</tr>
		</table>
	</form>
</Center>
</body>
</html>