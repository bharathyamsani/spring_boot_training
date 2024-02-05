package com.example.timestamp.service;

import java.util.List;

import com.example.timestamp.model.Student;

public interface StudentService {

	Student addStudent(Student s);

	Student getStudentById(long id);

	List<Student> getAllStudents();

	Student updateStudent(Student s, long id);

	void deleteStudentById(long id);

}
