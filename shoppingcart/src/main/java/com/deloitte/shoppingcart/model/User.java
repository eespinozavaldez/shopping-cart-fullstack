package com.deloitte.shoppingcart.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GenericGenerator(name="USER_ID", strategy="com.deloitte.shoppingcart.idgenerator.CustomIdGenerator")
	@GeneratedValue(generator="USER_ID")
	@Column(name = "USER_ID")
	private int userId;
	@Column(name = "NAME")
	private String name;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "BIO")
	private String bio;
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	@Column(name = "AREA_OF_INTEREST")
	private String areaOfInterest;
	@Column(name = "PASSWORD")
	private String password;
	


	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<OrderHistory> orderHistoryList;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<WishList> wishList;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(String areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public List<OrderHistory> getOrderHistoryList() {
		return orderHistoryList;
	}

	public void setOrderHistoryList(List<OrderHistory> orderHistoryList) {
		this.orderHistoryList = orderHistoryList;
	}

	public List<WishList> getWishList() {
		return wishList;
	}

	public void setWishList(List<WishList> wishList) {
		this.wishList = wishList;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
