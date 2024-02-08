package com.example.springmanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmanytomany.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
