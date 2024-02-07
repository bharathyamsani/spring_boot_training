package com.example.jdbcexample.service;

import java.util.List;

import com.example.jdbcexample.model.Student;

public interface StudentService {
	String addStudent(Student s);

	List<Student> getAllStudents();

	Student getStudent(long id);

	String updateStudent(long id, Student s);

	String deleteStudent(long id);

}
