package com.example.nativequeries.service;

import java.util.List;

import com.example.nativequeries.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployeesByName(String name);

	Employee addEmployee(Employee e);

	List<Employee> empWithSalGreater(float sal);

	List<Employee> empJoinDept(String dept);

	List<Employee> getAllEmployees();

	List<Employee> empSortBySal();

	String avgSal();

}
