package com.example.jdbcexample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jdbcexample.model.Student;
import com.example.jdbcexample.repository.StudentRepository;
import com.example.jdbcexample.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public String addStudent(Student s) {
		return studentRepository.addStudent(s);
	}

	public List<Student> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	public Student getStudent(long id) {
		return studentRepository.getStudent(id);
	}

	public String updateStudent(long id, Student s) {
		return studentRepository.updateStudent(id, s);
	}

	public String deleteStudent(long id) {
		return studentRepository.deleteStudent(id);
	}

}
