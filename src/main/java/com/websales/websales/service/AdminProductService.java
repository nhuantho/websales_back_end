package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.AdminProduct;
import com.websales.websales.responsitory.AdminProductResponitory;

@Service
public class AdminProductService {
    @Autowired
    private AdminProductResponitory responitory;

    public AdminProduct saveAdminProduct(AdminProduct adminProduct){
        return responitory.save(adminProduct);
    }

    public List<AdminProduct> saveAdminProducts(List<AdminProduct> adminProducts){
        return responitory.saveAll(adminProducts);
    }

    public List<AdminProduct> getAdminProducts(){
        return responitory.findAll();
    }

    public AdminProduct getAdminProductById(int id){
        return responitory.findById(id).orElse(null);
    }

    public String deleteAdminProduct(int id){
        responitory.deleteById(id);
        return "AdminProduct removed " + id;
    }

    public AdminProduct updateAdminProduct(AdminProduct adminProduct){
        AdminProduct existingAdminProduct = responitory.findById(adminProduct.getId()).orElse(null);
        existingAdminProduct.setUser(adminProduct.getUser());
        existingAdminProduct.setProduct(adminProduct.getProduct());
        existingAdminProduct.setDateEdit(adminProduct.getDateEdit());
        existingAdminProduct.setInfoEdit(adminProduct.getInfoEdit());
        return responitory.save(existingAdminProduct);
    }
}
