package com.deloitte.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.shoppingcart.model.User;
import com.deloitte.shoppingcart.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/users")
public class UserController {

	 @Autowired
	 private UserService userService;

	// get a list of all users
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	// get a user by id
	@GetMapping("/{userId}")
	public Optional<User> getUserById(@PathVariable("userId") int userId) {
		return userService.getUserById(userId);
	}
	
	// create a new user, validate with email.
	   @PostMapping("/add")
	    public String newUser(@RequestBody User user) {
	        return userService.newUser(user);
	    }

	//update user, only email and area of interest.
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User user) {
		return userService.updateUser(userId, user);
	}
	
	
	//get list of users by name
	@GetMapping("/usersname/{name}")
	public List<User> findUserByName(@PathVariable String name) {
		return userService.findUserByName(name);
	}

	//get list of users by email
	@GetMapping("/usersemail/{email}")
	public User findUserByEmail(@PathVariable String email) {
		return userService.findUserByEmail(email);
	}
	
	//delete user by id
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
	}
	


}
