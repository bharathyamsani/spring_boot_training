package com.example.springbootwebapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootwebapp.dto.EmployeeDto;
import com.example.springbootwebapp.exception.ResourceNotFoundException;
import com.example.springbootwebapp.model.Employee;
import com.example.springbootwebapp.repository.EmployeeRepository;
import com.example.springbootwebapp.service.DepartmentService;
import com.example.springbootwebapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentService departmentService;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto e) {
		Employee emp = new Employee();
		emp.setDept(departmentService.getDepartmentById(e.getDept_id()));
		emp.setEmail(e.getEmail());
		emp.setFirstName(e.getFirstName());
		emp.setLastName(e.getLastName());
		emp = employeeRepository.save(emp);
		e.setDept_id(emp.getDept().getDept_id());
		e.setId(emp.getId());
		return e;
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<EmployeeDto> l = new ArrayList<>();
		for (Employee emp : employeeRepository.findAll()) {
			EmployeeDto e = new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(),
					emp.getDept().getDept_id());
			l.add(e);
		}
		return l;
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			Employee emp = employee.get();
			EmployeeDto e = new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(),
					emp.getDept().getDept_id());
			return e;
		}
		throw new ResourceNotFoundException("Employee", "id", id);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto e, long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			emp.get().setFirstName(e.getFirstName());
			emp.get().setLastName(e.getLastName());
			emp.get().setEmail(e.getEmail());
			employeeRepository.save(emp.get());
			Employee employee = emp.get();
			return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(),
					employee.getEmail(), employee.getDept().getDept_id());
		}
		throw new ResourceNotFoundException("Employee", "id", id);
	}

	@Override
	public void deleteEmployee(long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			employeeRepository.deleteById(id);
		}
		throw new ResourceNotFoundException("Employee", "id", id);
	}

	public boolean hasEmployee(long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		return emp.isPresent();
	}

}
