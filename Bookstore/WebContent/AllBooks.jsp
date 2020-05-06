<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.model.Book,com.dao.bookDao,java.util.*"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Store Application</title>
<style type="text/css">
</style>
</head>
<body>
	
	<center>
		<h1 align="center">Books Management</h1>
		<a href="AddBooks.jsp" style="color: blue; font-size: 20px;">Add
			New Book</a> &nbsp; &nbsp; &nbsp; 
			<a href="ListServlet"
			style="color: blue; font-size: 20px;">List All Books</a> <br>
		<h3>List All Books</h3>

		<div class="container">
			<table border="1" align="center">
				<tr>
					<th style="width: 30px">ID</th>
					<th style="width: 200px">Title</th>
					<th style="width: 150px">Author</th>
					<th style="width: 50px">Price</th>
					<th style="width: 100px">Actions</th>
				</tr>
				<c:forEach items="${list}" var="book">

					<tr>
						<td>${book.id }</td>
						<td>${book.title}</td>
						<td>${book.author }</td>
						<td>${book.price }</td>
						<td><a href="EditServlet?id=${book.id}">Edit</a>&nbsp; &nbsp;
							<a href="DeleteServlet?id=${book.id}">Delete</a></td>


					</tr>


				</c:forEach>
			</table>


		</div>

	</center>
</body>
</html>