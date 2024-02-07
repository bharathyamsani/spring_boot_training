package com.example.springbootwebapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwebapp.exception.ResourceNotFoundException;
import com.example.springbootwebapp.model.Department;
import com.example.springbootwebapp.repository.DepartmentRepository;
import com.example.springbootwebapp.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(Department d) {
		return departmentRepository.save(d);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(long id) {
		return departmentRepository.findById(id).get();
	}

	@Override
	public Department updateDepartment(long id, Department d) throws ResourceNotFoundException {
		Department dept = departmentRepository.findById(id).get();
		dept.setDept_name(d.getDept_name());
		return departmentRepository.save(dept);
	}

	@Override
	public void deleteDepartment(long id) throws ResourceNotFoundException {
		departmentRepository.deleteById(id);
		return;
	}

}
