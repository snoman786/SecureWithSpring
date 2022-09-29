package com.noman.dao;

import com.noman.model.Users;



public interface UserDao {
	
	Users findByUserName(String username);
}
