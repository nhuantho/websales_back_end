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
@Table(name = "cart")
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(nullable = false)
    private int client_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="client_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_user_cart"), insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	User user;
	@Column(nullable = false)
    private int product_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_product_cart"), insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	Product product;
	private int size_id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="size_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_size_cart"), insertable = false, updatable = false, nullable = false)
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	Size size;
	@Column(nullable = false)
    private String extraDate;
	@Column(nullable = false)
    private int quatity;
}
