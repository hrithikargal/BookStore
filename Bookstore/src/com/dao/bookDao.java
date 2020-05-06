package com.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Book;
import com.model.User;

public class bookDao {

	public static String url = "jdbc:mysql://localhost:3306/cognizant";
	public static String driverName = "com.mysql.cj.jdbc.Driver";
	public static String user = "root";
	public static String password = "root";


	Connection con = null;

	public Connection getDbConnection() {

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			System.out.println("Unable to find the Driver");
		}

		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Unable to Connect with Database" + e);
		}
		return con;

	}

	public void addNewBook(Book book) {
		Connection con = getDbConnection();
		String sql = "insert into book(title,author,price) values(?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setFloat(3, book.getPrice());
			int rs = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL Error in adding new book");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Book> ListBook() {
			
			ArrayList<Book> books=new ArrayList<Book>();
			Connection con = getDbConnection();
			
		try{
				String sql = "select * from book";
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
		    
				while(rs.next())
				{
					Book book = new Book();
		      
					book.setId(rs.getInt("book_id"));
					book.setTitle(rs.getString("title"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getFloat("price"));
					
					books.add(book);
				}
		    
		    }
		    catch(Exception e)
		    {
		        System.out.println("Sql Error in listing all books");
		    } finally {
		
		    	try {
			
		    		con.close();
	
		    	} catch (SQLException e) {
				// TODO Auto-generated catch block
			    		e.printStackTrace();
		}
		    
	}
		System.out.println("BOOK--> " + books);
		return books;
	}

	public void update(Book book) {
		Connection con = getDbConnection();
		String sql = "update book set title=?, author=?, price=? where book_id=?";
		try {

			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setFloat(3, book.getPrice());
			pstmt.setInt(4, book.getId());
			int rs = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("SQL Error in updating book");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	public boolean updateBookById(Book book) {
		Connection con=getDbConnection();
		String sql="update user set title=?,author=?,price=?where book_id=?";
		try {
			PreparedStatement psmt=con.prepareStatement(sql);
			psmt.setInt(1, book.getId());
			psmt.setString(2,book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setFloat(4, book.getPrice());
						
			int rs = psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL Error in updating book");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public Book getBookById(int id) {
		Book book = new Book();
		Connection con = getDbConnection();
		String sql = "select * from book where book_id=?";
		try {

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				float price = rs.getFloat("price");
				book.setId(id);
				book.setTitle(title);
				book.setAuthor(author);
				book.setPrice(price);
			}

		} catch (SQLException e) {
			System.out.println("SQL Error in getting book by ID");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return book;
	}
	

	public boolean deleteBookbyid(Book book) {
		Connection con = getDbConnection();
		String sql = "delete from book where book_id=?";
		try {
			System.out.println("SQL Delete");
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, book.getId());
			int rs = pstmt.executeUpdate();
			//list.remove(book);
		} catch (SQLException e) {
			System.out.println("SQL Error in deleting book");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}