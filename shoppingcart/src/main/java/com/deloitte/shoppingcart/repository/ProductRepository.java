package com.deloitte.shoppingcart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.shoppingcart.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

	List<Product> findByPrice(double price);

	List<Product> findAllByProductId(int productId);
}
