package com.deloitte.shoppingcart.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.shoppingcart.model.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

	List<WishList> findAllByUserUserId(int userId);
	
	@Modifying
    @Query("DELETE FROM WishList w WHERE w.product.productId = :productId")
    void deleteProductWishlist(@Param("productId") int productId);
	
	@Modifying
	@Query("DELETE WishList w WHERE w.user.userId = :userId")
	void deleteWishListByUser(@Param("userId") int userId);

	
}
