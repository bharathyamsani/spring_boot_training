package com.example.nativequeries.service;

import java.util.List;

import com.example.nativequeries.model.Department;

public interface DepartmentService {

	Department addDepartment(Department dept);

	List<Department> getDepartments();

}
