package com.dao;
import com.dao.bookDetail;
import com.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class UserDaoImpl implements UserDao {

	public static String url = "jdbc:mysql://127.0.0.1:3306/cognizant";
	public static String driverName = "com.mysql.cj.jdbc.Driver";
	public static String user = "root";
	public static String password = "root";
	

	public Connection getDbConnection() {
		Connection connection = null;
		// Step 0 : load Driver
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e1) {
			System.out.println("Unable to find the Driver");
		}

		try {
			// Step 1 : Get Connection Object using DriverManager
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("Unable to Connect with DB" + e);
		}
		return connection;

	}
	
	
	
	@Override
	public boolean deleteUserByid(Integer id) {
		Connection connection=getDbConnection();
		String sql="delete from book where id=?";
		
		try {
			PreparedStatement psmt=connection.prepareStatement(sql);
			psmt.setInt(1, id);
			int executeUpdate = psmt.executeUpdate();
			if(executeUpdate>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    return false;
	}
	@Override
	public String addUserDetail(bookDetail user) {
		System.out.println("inside addbookdetail");
		System.out.println(user);

		Connection connection = getDbConnection();

		System.out.println(connection);

		if (connection != null) {
			String sql = "insert into book(title,author,price) values(?,?,?)";
			try {
				PreparedStatement psmt = connection.prepareStatement(sql);
				psmt.setString(1, user.getTitle());
				psmt.setString(2, user.getAuthor());
				psmt.setDouble(3, user.getPrice());
			
				int noOfRowsAffected = psmt.executeUpdate();
				System.out.println(noOfRowsAffected);

				if (noOfRowsAffected > 0) {
					System.out.println("Data Inserted Sucessfully\";");
					return "Data Inserted Sucessfully";

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return null;
	}

	@Override
	public ArrayList<bookDetail> getAllUserDetails() {
		ArrayList<bookDetail> bookList=new ArrayList<bookDetail>();
		Connection connection = getDbConnection();
		//String sql = "select * from user";
		try {
			// Step 2 : Get Statement Object using connection
			PreparedStatement psmt = connection.prepareStatement("select * from book");
			// Step 3 : Execute the Query
			ResultSet rs = psmt.executeQuery();
			// Step 4 : Process the ResultSet and print the values
			while (rs.next()) {
				bookDetail book = new bookDetail();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("Price"));
				
				bookList.add(book);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        System.out.println("--> " + bookList);
		return bookList;
	}

	@Override
	public bookDetail getUserById(Integer id) {
       bookDetail book=null; 
        Connection connection=getDbConnection();
        
        try {
        	//step 3
			PreparedStatement psmt=connection.prepareStatement("select * from user where id=?");
			psmt.setInt(1, id);
			//step 4
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				book = new bookDetail();
			book.setId(rs.getInt(id));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getDouble("Price"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				//step 5
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        
		return book;
	}
	
	@Override
	public boolean updateUserById(bookDetail book) {
		Connection connection=getDbConnection();
		String sql="update user set title=?,author=?,price=?, where id=?";
		try {
			PreparedStatement psmt=connection.prepareStatement(sql);
			psmt.setString(1, book.getTitle());
			psmt.setString(2,book.getAuthor());
			psmt.setDouble(3, book.getPrice());

						
			int executeUpdate = psmt.executeUpdate();
			if(executeUpdate>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	
	

}