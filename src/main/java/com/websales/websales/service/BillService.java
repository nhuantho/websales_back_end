package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.Bill;
import com.websales.websales.responsitory.BillResponitory;

@Service
public class BillService {
    @Autowired
    private BillResponitory responitory;

    public Bill saveBill(Bill bill){
        return responitory.save(bill);
    }

    public List<Bill> saveBills(List<Bill> bills){
        return responitory.saveAll(bills);
    }

    public List<Bill> getBills(){
        return responitory.findAll();
    }

    public Bill getBillById(int id){
        return responitory.findById(id).orElse(null);
    }
    
    public Bill getBillLastRow(){
        return responitory.findBillLastRow();
    }
    
    public List<Bill> getBillByClientId(int client_id){
        return responitory.findBillByClientId(client_id);
    }

    public String deleteBill(int id){
        responitory.deleteById(id);
        return "Bill removed " + id;
    }

    public Bill updateBill(Bill bill){
        Bill existingBill = responitory.findById(bill.getId()).orElse(null);
        existingBill.setUser(bill.getUser());
        existingBill.setDatePayment(bill.getDatePayment());
        existingBill.setInfoPayment(bill.getInfoPayment());
        return responitory.save(existingBill);
    }
}
