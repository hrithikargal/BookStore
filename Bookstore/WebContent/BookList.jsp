<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.model.Book,com.dao.bookDao,java.util.*",pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of All Books</title>
<style type="text/css">

#whole {
	width: 60%;
	margin: auto;
}
th, td {
	padding: 7px;
}
</style>
</head>
<body>
<center>
	<div id="whole">
		<%
			Book book = new Book();
			bookDao dao = new bookDao();
			ArrayList<Book> list = dao.Listbook();
		%>
		<h1 align="center">Books Management</h1>
		<a href="AddBooks.jsp" style="color: blue; font-size: 20px;" >Add New Book</a>
			&nbsp; &nbsp; &nbsp; 
		 <a href="AllBooks.jsp" style="color: blue; font-size: 20px;">List All Books</a> <br>
		<h3>List All Books</h3>

		<table border="1" align="center">
			<tr>
				<th style="width: 30px">ID</th>
				<th style="width: 200px">Title</th>
				<th style="width: 150px">Author</th>
				<th style="width: 50px">Price</th>
				<th style="width: 100px">Actions</th>
			</tr>
			<%
				if (list != null) {
					for (Book b : list) {
			%>
			<tr>
				<td>
					<%
						out.println(b.getId());
					%>
				</td>
				<td>
					<%
						out.println(b.getTitle());
					%>
				</td>
				<td>
					<%
						out.println(b.getAuthor());
					%>
				</td>
				<td>
					<%
						out.println(b.getPrice());
					%>
				</td>
				<td><a href="EditServlet?id=${Book.id}">Edit</a>&nbsp; &nbsp; 
				<a href="deleteServlet?id=${Book.id}">Delete</a></td>
				
				<%
					}
					}
				%>
			</tr>
		</table>
	</div>
</center>
</body>
</html>