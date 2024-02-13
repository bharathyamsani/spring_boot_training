package com.example.nativequeries.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nativequeries.model.Department;
import com.example.nativequeries.repository.DepartmentRepository;
import com.example.nativequeries.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public Department addDepartment(Department dept) {
		return deptRepo.save(dept);
	}

	@Override
	public List<Department> getDepartments() {
		return deptRepo.findAll();
	}

}
