package com.example.springmanytomany.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	@Column(name = "bookName")
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("books")
	private Author author;
	@Column(name = "bookPrice")
	private float price;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "bookId"), inverseJoinColumns = @JoinColumn(name = "genreId"))
	@JsonIgnoreProperties("books")
	private List<Genre> genres;

}
