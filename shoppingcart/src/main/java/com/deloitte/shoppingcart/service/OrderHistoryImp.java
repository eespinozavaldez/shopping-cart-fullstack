package com.deloitte.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.shoppingcart.exception.OrderNotFoundException;
import com.deloitte.shoppingcart.exception.OrderRunOffInventoryException;
import com.deloitte.shoppingcart.model.OrderHistory;
import com.deloitte.shoppingcart.model.Product;
import com.deloitte.shoppingcart.model.User;
import com.deloitte.shoppingcart.repository.OrderHistoryRepository;
import com.deloitte.shoppingcart.repository.ProductRepository;
import com.deloitte.shoppingcart.repository.UserRepository;

@Service
public class OrderHistoryImp implements OrderHistoryService{
	
	@Autowired
	private OrderHistoryRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<OrderHistory> getAllOrderHistories() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<OrderHistory> getOrderHistoryByid(int orderId) {
		Optional<OrderHistory> order =  orderRepository.findById(orderId);
		 if (order.isEmpty()) {
			 throw new OrderNotFoundException("Order History with id: " + orderId + " not found");
		 }
		 
		 return order;
	}

	@Override
	public List<OrderHistory> getOrderHstoryByUser(int userId) {
		return orderRepository.findAllByUserUserId(userId);
	}

	@Override
	public Optional<OrderHistory> addProductOrderHistory(OrderHistory order) {
		int userId = order.getUser().getUserId();
		User user = userRepository.findById(userId).get();
		order.setUser(user);
		
		int productId = order.getProduct().getProductId();
		Product product = productRepository.findById(productId).get();
		order.setProduct(product);
		
		boolean orderProductHistory = product.getTotalProductsInventory() == 0 ;
		
		if(orderProductHistory) {
			throw new OrderRunOffInventoryException("There is no more inventory for the product: " + product.getName());
			
		}else {
			product.setTotalProductsInventory(product.getTotalProductsInventory() -1);
			orderRepository.save(order);
			
		    return Optional.of(order);
		}
		
		
	}

	@Override
	public void deleteOrderByUser(int userId) {
		orderRepository.deleteOrdeByUser(userId);
		
	}

	
	
}
