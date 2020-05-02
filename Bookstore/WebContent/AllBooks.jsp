<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.model.Book,com.dao.bookDao,java.util.*" pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}
#main {
	width: 60%;
	margin: auto;
}
th, td {
	padding: 7px;
}
</style>
</head>
<body>
	<div id="main">
		<%
			bookDao dao = new bookDao();
			ArrayList<Book> list = dao.ListBook();
			Book book = new Book();
		%>
		<h1 align="center">Books Management</h1>
		<a href="AddBooks.jsp" style="color: blue; font-size: 20px;" >Add New Book</a>
			&nbsp; &nbsp; &nbsp; 
		 <a href="AllBooks.jsp" style="color: blue; font-size: 20px;">List All Books</a> <br>
		<h3>List All Books</h3>
	<center>    <h2>Welcome Book </h2> 
		<h3>List of Book :- </h3>
		
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Author</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.price}</td>
					<td><a href="EditServlet?book_id=${book.id}">Edit</a>  :  <a href="DeleteServlet?bookid=${book.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

</center>
	</div>
</body>
</html>