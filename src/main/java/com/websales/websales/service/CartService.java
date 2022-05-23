package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.Cart;
import com.websales.websales.responsitory.CartResponitory;

@Service
public class CartService {
    @Autowired
    private CartResponitory responitory;

    public Cart saveCart(Cart cart){
        return responitory.save(cart);
    }

    public List<Cart> saveCarts(List<Cart> carts){
        return responitory.saveAll(carts);
    }

    public List<Cart> getCarts(){
        return responitory.findAll();
    }

    public Cart getCartById(int id){
        return responitory.findById(id).orElse(null);
    }
    
    public List<Cart> getBillByClientId(int client_id){
        return responitory.findBillByClientId(client_id);
    }
    
    public String deleteCart(int id){
        responitory.deleteById(id);
        return "Cart removed " + id;
    }
    
    public String deleteCartByProductId(int product_id){
        responitory.deleteCartByProductId(product_id);
        return "Cart removed " + product_id;
    }
    
    public String deleteAllCart(int client_id) {
    	responitory.deleteAllCart(client_id);
    	return "Done";
    }

}
