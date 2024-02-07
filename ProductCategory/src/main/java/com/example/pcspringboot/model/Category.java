package com.example.pcspringboot.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long categoryId;
	@Column(name = "categoryName", nullable = false)
	private String categoryName;
	@JsonIgnoreProperties("category")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product> products;
}
