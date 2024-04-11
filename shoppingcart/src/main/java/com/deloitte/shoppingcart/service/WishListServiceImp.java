package com.deloitte.shoppingcart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.shoppingcart.model.Product;
import com.deloitte.shoppingcart.model.User;
import com.deloitte.shoppingcart.model.WishList;
import com.deloitte.shoppingcart.repository.ProductRepository;
import com.deloitte.shoppingcart.repository.UserRepository;
import com.deloitte.shoppingcart.repository.WishListRepository;

@Service
public class WishListServiceImp implements WishListService {

	@Autowired
	private WishListRepository wishListRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<WishList> getAllWishLists() {
		return wishListRepository.findAll();
	}

	@Override
	public WishList getWishListById(int wishId) {
		return wishListRepository.findById(wishId).orElse(null);
	}

	@Override
	public List<WishList> getwWishListByUser(int userId) {
		return wishListRepository.findAllByUserUserId(userId);
	}

	@Override
	public WishList addWishList(WishList wishList) {
		int userId = wishList.getUser().getUserId();
		User user = userRepository.findById(userId).get();
		wishList.setUser(user);

		int productId = wishList.getProduct().getProductId();
		Product product = productRepository.findById(productId).get();
		wishList.setProduct(product);

		return wishListRepository.save(wishList);
	}

	@Override
	public void deleteProductWishlist(int productId) {
		wishListRepository.deleteProductWishlist(productId);

	}

	@Override
	public void deleteWishlistByUser(int userId) {
		wishListRepository.deleteWishListByUser(userId);

	}

}
