package com.dao;
import com.dao.bookDetail;

import java.util.ArrayList;



public interface UserDao {

	public String addUserDetail(bookDetail book);
	
	

	public ArrayList<bookDetail> getAllUserDetails();

	public bookDetail getUserById(Integer id);
	
	public boolean updateUserById(bookDetail book);
	
	public boolean deleteUserByid(Integer id);
	
}