package com.example.timestamp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.timestamp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
