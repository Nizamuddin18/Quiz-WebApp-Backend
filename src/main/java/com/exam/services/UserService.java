package com.exam.services;

import java.util.Set;
import com.exam.model.User;
import com.exam.model.UserRole;

public interface UserService {
	// creating User 
	public User createUser(User user , Set<UserRole> userRoles) throws Exception;
	//Fetching UserDetails
	public User getUser(String userName);
	//Deleting User
	public void deleteUser(Long userId);
}
