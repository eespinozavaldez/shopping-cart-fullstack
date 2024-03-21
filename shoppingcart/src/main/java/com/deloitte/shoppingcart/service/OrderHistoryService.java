package com.deloitte.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.deloitte.shoppingcart.model.OrderHistory;

public interface OrderHistoryService {

	public List<OrderHistory> getAllOrderHistories();
	
	public Optional<OrderHistory> getOrderHistoryByid(int orderId);
	
	public List<OrderHistory> getOrderHstoryByUser( int userId);
	
	public String addProductOrderHistory(OrderHistory order);
	
	public void deleteOrderByUser(int userId);
}
