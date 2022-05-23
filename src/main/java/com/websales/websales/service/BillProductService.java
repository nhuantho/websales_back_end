package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.BillProduct;
import com.websales.websales.responsitory.BillProductResponitory;

@Service
public class BillProductService {
    @Autowired
    private BillProductResponitory responitory;

    public BillProduct saveBillProduct(BillProduct billProduct){
        return responitory.save(billProduct);
    }

    public List<BillProduct> saveBillProducts(List<BillProduct> billProducts){
        return responitory.saveAll(billProducts);
    }

    public List<BillProduct> getBillProducts(){
        return responitory.findAll();
    }

    public BillProduct getBillProductById(int id){
        return responitory.findById(id).orElse(null);
    }
    
    public List<BillProduct> getBillProductByProductId(int product_Id) {
    	return responitory.findByProductId(product_Id);
    }
    
    public List<BillProduct> getBillProductByBillId(int bill_id) {
    	return responitory.findByBillId(bill_id);
    }

    public String deleteBillProduct(int id){
        responitory.deleteById(id);
        return "BillProduct removed " + id;
    }
    
    public String deleteBillProductByProductId(int product_id){
        responitory.deleteBillProductByProductId(product_id);
        return "Product_id removed " + product_id;
    }
    
    public String deleteBillProductByBillId(int bill_id){
        responitory.deleteBillProductByProductId(bill_id);
        return "Bill_id removed " + bill_id;
    }

    public BillProduct updateBillProduct(BillProduct billProduct){
        BillProduct existingBillProduct = responitory.findById(billProduct.getId()).orElse(null);
        existingBillProduct.setBill(billProduct.getBill());
        existingBillProduct.setProduct(billProduct.getProduct());
        existingBillProduct.setQuatity(billProduct.getQuatity());
        existingBillProduct.setUnitPrice(billProduct.getUnitPrice());
        return responitory.save(existingBillProduct);
    }
}
