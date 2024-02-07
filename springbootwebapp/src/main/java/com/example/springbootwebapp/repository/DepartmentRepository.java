package com.example.springbootwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootwebapp.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
