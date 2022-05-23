package com.websales.websales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "billproduct")
public class BillProduct {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(nullable = false)
    private int bill_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="bill_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_bill_billproduct"), insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	Bill bill;
	@Column(nullable = false)
    private int product_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_product_billproduct"), insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	Product product;
	@Column(nullable = false)
    private int quatity;
	@Column(nullable = false)
    private int unitPrice;
}
