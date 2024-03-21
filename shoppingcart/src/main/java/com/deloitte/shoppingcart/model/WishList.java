package com.deloitte.shoppingcart.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "WISHLIST")
public class WishList {
	@Id
	@GenericGenerator(name="WISH_ID", strategy="com.deloitte.shoppingcart.idgenerator.CustomIdGenerator")
	@GeneratedValue(generator="WISH_ID")
	@Column(name = "WISH_ID")
	private int wishId;
	
	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	
	public int getWishId() {
		return wishId;
	}

	public void setWishId(int wishId) {
		this.wishId = wishId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
}
