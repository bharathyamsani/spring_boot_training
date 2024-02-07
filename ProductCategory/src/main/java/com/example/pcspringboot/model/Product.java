package com.example.pcspringboot.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long productId;
	@Column(name = "productName")
	private String productName;
	@Column(name = "productPrice")
	private float productPrice;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	private Category category;

}
