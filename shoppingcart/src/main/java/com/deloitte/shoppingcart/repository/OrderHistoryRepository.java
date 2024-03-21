package com.deloitte.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.shoppingcart.model.OrderHistory;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Integer> {

	List<OrderHistory> findAllByUserUserId(int userId);
	
	@Modifying
	@Query("DELETE OrderHistory w WHERE w.user.userId = :userId")
	void deleteOrdeByUser(@Param("userId") int userId);

}
