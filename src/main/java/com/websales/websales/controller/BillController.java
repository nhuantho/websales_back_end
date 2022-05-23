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

import com.websales.websales.model.Bill;
import com.websales.websales.service.BillService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class BillController {
    @Autowired
    private BillService service;

    @PostMapping("/addBill")
    public Bill addBill(@RequestBody Bill bill){
        return service.saveBill(bill);
    }

    @PostMapping("/addBills")
    public List<Bill> addBills(@RequestBody List<Bill> bills){
        return service.saveBills(bills);
    }

    @GetMapping("/bills")
    public List<Bill> findAlLProducts(){
        return service.getBills();
    }

    @GetMapping("/billById/{id}")
    public Bill findBillById(@PathVariable int id){
        return service.getBillById(id);
    }
    
    @GetMapping("/billLastRow")
    public Bill findBillLastRow(){
        return service.getBillLastRow();
    }
    
    @GetMapping("/billByClientId/{client_id}")
    public List<Bill> findBillByClientId(@PathVariable int client_id){
        return service.getBillByClientId(client_id);
    }

    @PutMapping("/updateBill")
    public Bill update(@RequestBody Bill bill){
        return service.updateBill(bill);
    }

    @DeleteMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable int id){
        return service.deleteBill(id);
    }
}