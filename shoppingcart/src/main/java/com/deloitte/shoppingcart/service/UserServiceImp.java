package com.deloitte.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.shoppingcart.exception.UserNotFoundException;
import com.deloitte.shoppingcart.model.User;
import com.deloitte.shoppingcart.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(int userId) {
		Optional<User> user =  userRepository.findById(userId);
		 if (user.isEmpty()) {
			 throw new UserNotFoundException("User with id: " + userId + " not found");
		 }
		 
		 return user;
	}

	@Override
	public String newUser(User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "User already exists";
        } else {
            userRepository.save(user);
            return "New User created";
        }
	}

	@Override
	public User updateUser(int userId, User user) {
		User updateUser = userRepository.findById(userId).orElse(null);
		updateUser.setEmail(user.getEmail());
		updateUser.setAreaOfInterest(user.getAreaOfInterest());

		return userRepository.save(updateUser);
	}

	@Override
	public List<User> findUserByName(String name) {
		List<User> userName = userRepository.findByName(name);
		return userName;
	}

	@Override
	public User findUserByEmail(String email) {
		User userEmail = userRepository.findByEmail(email);
		return userEmail;
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);

		
	}
	
	
}
