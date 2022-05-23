package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.Product;
import com.websales.websales.responsitory.ProductResponitory;

@Service
public class ProductSevice {
    @Autowired
    private ProductResponitory responitory;

    public Product saveProduct(Product product){
        return responitory.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return responitory.saveAll(products);
    }

    public List<Product> getProducts(){
        return responitory.findAll();
    }

    public Product getProductById(int id){
        return responitory.findById(id).orElse(null);
    }

    public Product getNameProduct(String nameProduct){
        return responitory.findByNameProduct(nameProduct);
    }
    
    public Product getProductLastRow(){
        return responitory.lastRow();
    }
    
    public List<Product> getModel(String model){
        return responitory.findByModel(model);
    }
    
    public List<Product> getColor(String color){
        return responitory.findByColor(color);
    }
    
    public List<Product> getPrice(int price1, int price2){
        return responitory.findByPrice(price1, price2);
    }
    
    public List<Product> getSearchNamrProduct(String nameProduct){
        return responitory.findBySearchNamrProduct(nameProduct);
    }

    public String deleteProduct(int id){
        responitory.deleteById(id);
        return "product removed" + id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = responitory.findById(product.getId()).orElse(null);
        existingProduct.setNameProduct(product.getNameProduct());
        existingProduct.setModel(product.getModel());
        existingProduct.setImage(product.getImage());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescribes(product.getDescribes());
        existingProduct.setColor(product.getColor());
        return responitory.save(existingProduct);
    }
}
