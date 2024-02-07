package com.example.springbootwebapp.service;

import java.util.List;

import com.example.springbootwebapp.model.Department;

public interface DepartmentService {

	Department addDepartment(Department d);

	List<Department> getAllDepartments();

	Department getDepartmentById(long id);

	Department updateDepartment(long id, Department d);

	void deleteDepartment(long id);

}
