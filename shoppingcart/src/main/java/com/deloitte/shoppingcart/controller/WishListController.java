package com.deloitte.shoppingcart.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.shoppingcart.model.WishList;
import com.deloitte.shoppingcart.service.WishListService;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

	@Autowired
	WishListService wishListService;

	// get all Wish List
	@GetMapping("/all")
	public List<WishList> getAllWishLists() {
		return wishListService.getAllWishLists();

	}

	// get a wish list by id
	@GetMapping("/{wishId}")
	public WishList getWishListById(@PathVariable int wishId) {
		return wishListService.getWishListById(wishId);
	}

	// get a wish list by a specific user
	@GetMapping("/users/{userId}")
	public List<WishList> getwWishListByUser(@PathVariable("userId") int userId) {

		return wishListService.getwWishListByUser(userId);
	}

	// Create a new Wish list
	@PostMapping("/add")
	public WishList addWishList(@RequestBody WishList wishList) {
		return wishListService.addWishList(wishList);

	}

//	 Delete a product from wish list by a specific user
	@Transactional
	@DeleteMapping("/users/{userId}/removeproduct/{productId}")
	public void deleteProductWishlist(@PathVariable int userId, @PathVariable int productId) {
		 wishListService.deleteProductWishlist(userId, productId);
	}

	// Delete whole wish list from a user
	@Transactional
	@DeleteMapping("/users/{userId}")
	public void deleteWishlistByUser(@PathVariable int userId) {
		wishListService.deleteWishlistByUser(userId);
	}
}
