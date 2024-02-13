package com.example.nativequeries.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nativequeries.model.Employee;
import com.example.nativequeries.repository.EmployeeRepository;
import com.example.nativequeries.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getEmployeesByName(String name) {

		return (List<Employee>) empRepo.getEmployeesByName(name);
	}

	@Override
	public Employee addEmployee(Employee e) {
		return empRepo.save(e);
	}

	@Override
	public List<Employee> empWithSalGreater(float sal) {
		return (List<Employee>) empRepo.empWithSalGreater(sal);
	}

	@Override
	public List<Employee> empJoinDept(String dept) {
		return (List<Employee>) empRepo.empJoinDept(dept);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public List<Employee> empSortBySal() {
		return (List<Employee>) empRepo.sortBySal();
	}

	@Override
	public String avgSal() {
		return "Average Salary:" + empRepo.avgSal();
	}

}
