package com.example.timestamp.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.timestamp.model.Student;
import com.example.timestamp.repository.StudentRepository;
import com.example.timestamp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student s) {
		return studentRepository.save(s);
	}

	@Override
	public Student getStudentById(long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student s, long id) {
		Student student = getStudentById(id);
		student.setName(s.getName());
		student.setCourse(s.getCourse());
		student.setUpdated_on(LocalDateTime.now());
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
	}

}
