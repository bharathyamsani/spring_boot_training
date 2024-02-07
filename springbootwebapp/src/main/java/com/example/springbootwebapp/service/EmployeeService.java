package com.example.springbootwebapp.service;

import java.util.List;

import com.example.springbootwebapp.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto e);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto getEmployeeById(long id);

	EmployeeDto updateEmployee(EmployeeDto e, long id);

	void deleteEmployee(long id);

	boolean hasEmployee(long id);
}
