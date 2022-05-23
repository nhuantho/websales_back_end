package com.websales.websales.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.websales.websales.model.User;

public interface UserResponitory extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM websales.user where user.username = :username", nativeQuery = true)
	List<User> findByUsername(String username);
}
