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

import com.websales.websales.model.BillProduct;
import com.websales.websales.service.BillProductService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BillProductController {
    @Autowired
    private BillProductService service;

    @PostMapping("/addBillProduct")
    public BillProduct addBillProduct(@RequestBody BillProduct billProduct){
        return service.saveBillProduct(billProduct);
    }

    @PostMapping("/addBillProducts")
    public List<BillProduct> addBillProducts(@RequestBody List<BillProduct> billProducts){
        return service.saveBillProducts(billProducts);
    }

    @GetMapping("/billProducts")
    public List<BillProduct> findAllBillProducts(){
        return service.getBillProducts();
    }

    @GetMapping("/billProductById/{id}")
    public BillProduct findBillProductById(@PathVariable int id){
        return service.getBillProductById(id);
    }
    
    @GetMapping("/billProductByProductId/{product_Id}")
    public List<BillProduct> findBillProductByProductId(@PathVariable int product_Id){
        return service.getBillProductByProductId(product_Id);
    }
    
    @GetMapping("/billProductByBillId/{bill_Id}")
    public List<BillProduct> findBillProductBybillId(@PathVariable int bill_Id){
        return service.getBillProductByBillId(bill_Id);
    }
    
    @DeleteMapping("/deleteBillProductByProductId/{product_id}")
    public String deleteBillProductByProductId(@PathVariable int product_id){
        return service.deleteBillProductByProductId(product_id);
    }
    
    @DeleteMapping("/deleteBillProductByBillId/{bill_id}")
    public String deleteBillProductByBillId(@PathVariable int bill_id){
        return service.deleteBillProductByBillId(bill_id);
    }

    @PutMapping("/updateBillProduct")
    public BillProduct update(@RequestBody BillProduct billProduct){
        return service.updateBillProduct(billProduct);
    }

    @DeleteMapping("/deleteBillProduct/{id}")
    public String deleteBillProduct(@PathVariable int id){
        return service.deleteBillProduct(id);
    }
}