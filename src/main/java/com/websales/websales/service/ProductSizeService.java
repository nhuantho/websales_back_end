package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.ProductSize;
import com.websales.websales.responsitory.ProductSizeResponitory;

@Service
public class ProductSizeService {
    @Autowired
    private ProductSizeResponitory responitory;

    public ProductSize saveProductSize(ProductSize productSize){
        return responitory.save(productSize);
    }

    public List<ProductSize> saveProductSizes(List<ProductSize> productSizes){
        return responitory.saveAll(productSizes);
    }

    public List<ProductSize> getProductSizes(){
        return responitory.findAll();
    }

    public ProductSize getProductSizeById(int id){
        return responitory.findById(id).orElse(null);
    }
    
    public List<ProductSize> getProductSizeByProductId(int product_Id) {
    	return responitory.findByProductId(product_Id);
    }
    
    public List<ProductSize> getProductSizeBySizeId(int size_Id) {
    	return responitory.findBySizeId(size_Id);
    }
    
    public ProductSize getProductSizeByProductIdAndSizeId(int product_id, int size_id) {
    	return responitory.findByProductIdAndSizeId(product_id, size_id);
    }
    
    public String deleteProductSize(int id){
        responitory.deleteById(id);
        return "ProductSize removed " + id;
    }
    
    public String deleteProductSizeByProductId(int product_id){
        responitory.deleteProductSizeByProductId(product_id);
        return "Product_id removed " + product_id;
    }

    public ProductSize updateProductSize(ProductSize productSize){
        ProductSize existingProductSize = responitory.findById(productSize.getId()).orElse(null);
        existingProductSize.setQuantity(productSize.getQuantity());
        return responitory.save(existingProductSize);
    }
}
