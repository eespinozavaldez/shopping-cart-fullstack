package com.deloitte.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.shoppingcart.model.User;


public interface UserService {

	public List<User> getAllUsers();
	
	public Optional<User> getUserById(int userId);
	
	public Optional<User> newUser(User user);
	
	public User updateUser(int userId,  User user);
	
	public List<User> findUserByName(String name);
	
	public User findUserByEmail(String email);
	
	public void deleteUser(int userId);

	public User loginUser(User user);
	

}
