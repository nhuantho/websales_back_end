package com.websales.websales.responsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websales.websales.model.Sale;

public interface SaleResponsitory extends JpaRepository<Sale, Integer>{

}
