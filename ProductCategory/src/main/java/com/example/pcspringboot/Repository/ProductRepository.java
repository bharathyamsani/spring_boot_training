package com.example.pcspringboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pcspringboot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
