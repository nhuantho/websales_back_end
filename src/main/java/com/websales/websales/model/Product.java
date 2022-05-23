package com.websales.websales.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(nullable = false)
    private String nameProduct;
	@Column(nullable = false)
    private String model;
	@Column(nullable = false)
    private String image;
	@Column(nullable = false)
    private int price;
	@Column(nullable = true)
    private String describes;
	@Column(nullable = false)
    private String color;
}
