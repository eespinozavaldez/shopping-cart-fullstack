package com.deloitte.shoppingcart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.shoppingcart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByName(String name);

	User findByEmail(String email);

}
