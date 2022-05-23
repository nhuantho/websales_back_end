package com.websales.websales.responsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.websales.websales.model.Product;

public interface ProductResponitory extends JpaRepository<Product, Integer> {
    Product findByNameProduct(String nameProduct);
    List<Product> findByModel(String model);
    List<Product> findByColor(String color);
    @Query(value = "SELECT * FROM websales.product where product.price > :price1 and product.price < :price2", nativeQuery = true)
    List<Product> findByPrice(int price1, int price2);
    @Query(value="SELECT * FROM websales.product WHERE product.name_product LIKE %:nameProduct%", nativeQuery=true)
    List<Product> findBySearchNamrProduct(String nameProduct);
    @Query(value = "select *from websales.product ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Product lastRow();
}
