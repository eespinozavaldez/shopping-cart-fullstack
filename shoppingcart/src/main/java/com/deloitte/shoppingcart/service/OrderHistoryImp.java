package com.deloitte.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.shoppingcart.exception.OrderNotFoundException;
import com.deloitte.shoppingcart.model.OrderHistory;
import com.deloitte.shoppingcart.model.Product;
import com.deloitte.shoppingcart.repository.OrderHistoryRepository;
import com.deloitte.shoppingcart.repository.ProductRepository;

@Service
public class OrderHistoryImp implements OrderHistoryService{
	
	@Autowired
	private OrderHistoryRepository orderRepository;

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
	public String addProductOrderHistory(OrderHistory order) {
	int productId = order.getProduct().getProductId();
		
		Product product = productRepository.findById(productId).get();
		
		boolean orderProductHistory = product.getTotalProductsInventory() > 0 ;
		
		if(orderProductHistory) {
			product.setTotalProductsInventory(product.getTotalProductsInventory() -1);
			orderRepository.save(order);
			return "Product: " + product.getName() + " added successfully!";
			
		}else {
			
			orderRepository.save(order);
			return "There is no more inventory for the product: " + product.getName();
		}
	}

	@Override
	public void deleteOrderByUser(int userId) {
		orderRepository.deleteOrdeByUser(userId);
		
	}

	
	
}
