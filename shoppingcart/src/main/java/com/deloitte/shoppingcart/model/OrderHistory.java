package com.deloitte.shoppingcart.model;

import java.sql.Date;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_HISTORY")
public class OrderHistory {

	@Id
	@GenericGenerator(name="ORDER_ID", strategy="com.deloitte.shoppingcart.idgenerator.CustomIdGenerator")
	@GeneratedValue(generator="ORDER_ID")
	@Column(name = "ORDER_ID")
	private int orderId;
	@Column(name = "ORDER_DATE")
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;


	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
}
