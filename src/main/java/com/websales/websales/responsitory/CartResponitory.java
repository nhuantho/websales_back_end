package com.websales.websales.responsitory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.websales.websales.model.Cart;

public interface CartResponitory extends JpaRepository<Cart, Integer>{
	@Query(value = "SELECT * FROM websales.cart where cart.client_id = :client_id", nativeQuery = true)
	List<Cart> findBillByClientId(int client_id);
	@Modifying 
	@Transactional
	@Query(value = "DELETE FROM websales.cart where cart.client_id = :client_id", nativeQuery = true)
	void deleteAllCart(int client_id);
	@Modifying 
	@Transactional
	@Query(value = "DELETE FROM websales.cart where cart.product_id =:product_id", nativeQuery = true)
	void deleteCartByProductId(int product_id);
}
