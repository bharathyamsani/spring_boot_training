package com.example.springmanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmanytomany.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
