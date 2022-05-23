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

import com.websales.websales.model.GetProductSize;
import com.websales.websales.model.ProductSize;
import com.websales.websales.service.ProductSizeService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class ProductSizeController {
    @Autowired
    private ProductSizeService service;

    @PostMapping("/addProductSize")
    public ProductSize addProductSize(@RequestBody ProductSize productSize){
        return service.saveProductSize(productSize);
    }

    @PostMapping("/addProductSizes")
    public List<ProductSize> addProductSizes(@RequestBody List<ProductSize> productSizes){
        return service.saveProductSizes(productSizes);
    }
    
    @PostMapping("/productSizeByProductIdAndSizeId")
    public ProductSize findProductByProductIdAndSizeId(@RequestBody GetProductSize getProductSize){
    	return service.getProductSizeByProductIdAndSizeId(getProductSize.getProduct_id(), getProductSize.getSize_id());
    }

    @GetMapping("/productSizes")
    public List<ProductSize> findAlLProductSizes(){
        return service.getProductSizes();
    }

    @GetMapping("/productSizeById/{id}")
    public ProductSize findProductSizeById(@PathVariable int id){
        return service.getProductSizeById(id);
    }
    
    @GetMapping("/productSizeByProductId/{product_Id}")
    public List<ProductSize> findProductSizeByProductId(@PathVariable int product_Id){
        return service.getProductSizeByProductId(product_Id);
    }
    
    @GetMapping("/productSizeBySizeId/{size_Id}")
    public List<ProductSize> findProductSizeBySizeId(@PathVariable int size_Id){
        return service.getProductSizeBySizeId(size_Id);
    }

    @PutMapping("/updateProductSize")
    public ProductSize update(@RequestBody ProductSize productSize){
        return service.updateProductSize(productSize);
    }

    @DeleteMapping("/deleteProductSize/{id}")
    public String deleteProductSize(@PathVariable int id){
        return service.deleteProductSize(id);
    }
    
    @DeleteMapping("/deleteProductSizeByProductId/{product_id}")
    public String deleteProductSizeByProductId(@PathVariable int product_id){
        return service.deleteProductSizeByProductId(product_id);
    }
}