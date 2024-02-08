package com.example.springmanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springmanytomany.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}
