package com.yh.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yh.shopping.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
