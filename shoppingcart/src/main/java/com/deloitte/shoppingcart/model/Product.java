package com.deloitte.shoppingcart.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@GenericGenerator(name="PRODUCT_ID", strategy="com.deloitte.shoppingcart.idgenerator.CustomIdGenerator")
	@GeneratedValue(generator="PRODUCT_ID")
	@Column(name = "PRODUCT_ID")
	private int productId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRICE")
	private double price;
	@Lob
	@Column(name = "IMAGE")
	private String image;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "TOTAL_PRODUCTS_INVENTORY")
	private int totalProductsInventory;
	@Column(name = "STATUS")
	private boolean status;

	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderHistory> orderHistoryList;
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<WishList> wishLists;


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTotalProductsInventory() {
		return totalProductsInventory;
	}

	public void setTotalProductsInventory(int totalProductsInventory) {
		this.totalProductsInventory = totalProductsInventory;
	}

	public List<OrderHistory> getOrderHistoryList() {
		return orderHistoryList;
	}

	public List<WishList> getWishLists() {
		return wishLists;
	}


	

}
