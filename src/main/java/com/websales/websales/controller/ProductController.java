package com.websales.websales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.websales.model.Price;
import com.websales.websales.model.Product;
import com.websales.websales.service.ProductSevice;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductController {
    @Autowired
    private ProductSevice service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAlLProducts(){
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/productByName/{nameProduct}")
    public Product findProductByNameProduct(@PathVariable String nameProduct){
        return service.getNameProduct(nameProduct);
    }
    
    @GetMapping("/productByProductLastRow")
    public Product findProductByProductLastRow(){
        return service.getProductLastRow();
    }
    
    @GetMapping("/productByModel/{model}")
    public List<Product> findPrductByModel(@PathVariable String model){
        return service.getModel(model);
    }
    
    @GetMapping("/productByColor/{color}")
    public List<Product> findPrductByColor(@PathVariable String color){
        return service.getColor(color);
    }
    
    @PostMapping("/productByPrice")
    public List<Product> findProductByPrice(@RequestBody Price price){
    	return service.getPrice(price.getPrice1(), price.getPrice2());
    }
    
    @GetMapping("/productSreachByNameProduct/{nameProduct}")
    public List<Product> findProductSreachByNameProduct(@PathVariable String nameProduct){
    	return service.getSearchNamrProduct(nameProduct);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }
}