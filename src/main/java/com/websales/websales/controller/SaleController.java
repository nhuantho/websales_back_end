package com.websales.websales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.websales.model.Sale;
import com.websales.websales.service.SaleService;

@RestController
@CrossOrigin("http://localhost:3000/")
public class SaleController {

	@Autowired
    private SaleService service;

    @PostMapping("/addSale")
    public Sale addSale(@RequestBody Sale sale){
        return service.saveSale(sale);
    }

    @PostMapping("/addSales")
    public List<Sale> addSales(@RequestBody List<Sale> sales){
        return service.saveSales(sales);
    }

    @GetMapping("/sales")
    public List<Sale> findAlLSizes(){
        return service.getSales();
    }
    
    @PutMapping("/updateSale")
    public Sale update(@RequestBody Sale sale){
        return service.updateSale(sale);
    }
}
