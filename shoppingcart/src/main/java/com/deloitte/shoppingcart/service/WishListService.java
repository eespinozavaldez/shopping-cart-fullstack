package com.deloitte.shoppingcart.service;

import java.util.List;


import com.deloitte.shoppingcart.model.WishList;

public interface WishListService {

	public List<WishList> getAllWishLists();

	public WishList getWishListById(int wishId);

	public List<WishList> getwWishListByUser(int userId);

	public WishList addWishList(WishList wishList);

	public void deleteProductWishlist(int productId);

	public void deleteWishlistByUser(int userId);

}
