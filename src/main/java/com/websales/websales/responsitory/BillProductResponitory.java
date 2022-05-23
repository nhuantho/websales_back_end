package com.websales.websales.responsitory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.websales.websales.model.BillProduct;

public interface BillProductResponitory extends JpaRepository<BillProduct, Integer>{
	@Modifying 
	@Transactional
	@Query(value = "DELETE FROM websales.billproduct where billproduct.product_id =:product_id", nativeQuery = true)
	void deleteBillByProductId(int product_id);
	@Modifying 
	@Transactional
	@Query(value = "DELETE FROM websales.billproduct where billproduct.bill_id =:bill_id", nativeQuery = true)
	void deleteBillProductByProductId(int bill_id);
	List<BillProduct> findByProductId(int product_id);
	List<BillProduct> findByBillId(int bill_id);
}
