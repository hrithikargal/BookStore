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

public class bookDao {

	public static String url = "jdbc:mysql://localhost:3306/cognizant";
	public static String driverName = "com.mysql.cj.jdbc.Driver";
	public static String user = "root";
	public static String password = "root";
	
	public static ArrayList<Book> list = new ArrayList<>();
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
			Connection con = getDbConnection();
			String sql = "select * from book";
			try {
				Statement st = con.createStatement();
				
				ResultSet rs = st.executeQuery(sql);
				
				while (rs.next()) {
				
					Book book = new Book();
					
					book.setId(rs.getInt("book_id"));
					book.setTitle(rs.getString("title"));
					book.setAuthor(rs.getString("author"));
					book.setPrice(rs.getFloat("price"));
					
				list.add(book);
				}
		} catch (SQLException e) {
			System.out.println("SQL Error in listing all books");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
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