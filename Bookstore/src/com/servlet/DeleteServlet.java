package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.bookDao;
import com.model.Book;
/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String book_id = request.getParameter("book_id");
		int id = Integer.parseInt(book_id);
		response.getWriter().print("You have selected user Id : "+id);
		bookDao bookDao = new bookDao();
		com.model.Book del = bookDao.getBookById(id);
		if(del!=null)
		{
			boolean b = bookDao.deleteBookbyid(del);
			PrintWriter out = response.getWriter();
			out.println("Entry has been deleted successful");
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
