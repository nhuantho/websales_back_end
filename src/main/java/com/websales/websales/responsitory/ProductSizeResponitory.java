package com.websales.websales.responsitory;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.websales.websales.model.ProductSize;

public interface ProductSizeResponitory extends JpaRepository<ProductSize, Integer>{
	List<ProductSize> findByProductId(int product_id);
	List<ProductSize> findBySizeId(int size_id);
	@Modifying 
	@Transactional
	@Query(value = "DELETE FROM websales.productsize where productsize.product_id =:product_id", nativeQuery = true)
	void deleteProductSizeByProductId(int product_id);
	@Query(value = "SELECT * FROM websales.productsize where product_id = :product_id and size_id = :size_id", nativeQuery = true)
	ProductSize findByProductIdAndSizeId(int product_id, int size_id);
}
