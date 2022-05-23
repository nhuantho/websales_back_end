package com.websales.websales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.websales.model.Sale;
import com.websales.websales.responsitory.SaleResponsitory;

@Service
public class SaleService {
	@Autowired
    private SaleResponsitory responitory;
	
	public Sale saveSale(Sale sale){
        return responitory.save(sale);
    }

    public List<Sale> saveSales(List<Sale> sales){
        return responitory.saveAll(sales);
    }

    public List<Sale> getSales(){
        return responitory.findAll();
    }
    
    public Sale updateSale(Sale sale){
        Sale existingSale = responitory.findById(sale.getId()).orElse(null);
        existingSale.setModel(sale.getModel());
        existingSale.setSale(sale.getSale());
        return responitory.save(existingSale);
    }
}
