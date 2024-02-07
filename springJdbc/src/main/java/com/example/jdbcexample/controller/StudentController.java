package com.example.jdbcexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jdbcexample.model.Student;
import com.example.jdbcexample.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping
	public String addStudent(@RequestBody Student s) {
		return studentService.addStudent(s);
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("{id}")
	public Student getStudent(@PathVariable(name = "id") long id) {
		return studentService.getStudent(id);
	}

	@PutMapping("{id}")
	public String updateStudent(@PathVariable(name = "id") long id, @RequestBody Student s) {
		return studentService.updateStudent(id, s);
	}

	@DeleteMapping("{id}")
	public String deleteStudent(@PathVariable(name = "id") long id) {
		return studentService.deleteStudent(id);
	}

}
