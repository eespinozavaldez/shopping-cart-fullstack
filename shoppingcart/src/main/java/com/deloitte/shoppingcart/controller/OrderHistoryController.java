package com.deloitte.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.shoppingcart.model.OrderHistory;
import com.deloitte.shoppingcart.service.OrderHistoryService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/orderhistory")
public class OrderHistoryController {

	@Autowired
	OrderHistoryService orderService;

	// get all order history
	@GetMapping("/all")
	public List<OrderHistory> getAllOrderHistories() {
		return orderService.getAllOrderHistories();
	}

	// get a order history by id
	@GetMapping("/{orderId}")
	public Optional<OrderHistory> getOrderHistoryByid(@PathVariable int orderId) {
		return orderService.getOrderHistoryByid(orderId);
	}

	// get order history by specify user
	@GetMapping("/users/{userId}")
	public List<OrderHistory> getOrderHstoryByUser(@PathVariable("userId") int userId) {
		return orderService.getOrderHstoryByUser(userId);
	}

	// create a new order and add products.
	@PostMapping("/addproduct")
	public String addProductOrderHistory(@RequestBody OrderHistory order) {

		return orderService.addProductOrderHistory(order);

	}
	
	@Transactional
	@DeleteMapping("/users/{userId}")
	public void deleteOrderByUser(@PathVariable int userId) {
		orderService.deleteOrderByUser(userId);
	}

}
