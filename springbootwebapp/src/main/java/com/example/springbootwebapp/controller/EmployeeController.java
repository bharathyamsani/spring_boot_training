package com.example.springbootwebapp.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootwebapp.dto.EmployeeDto;
import com.example.springbootwebapp.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@PostMapping()
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employee) {
		return new ResponseEntity<EmployeeDto>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping
	public List<EmployeeDto> getAllEMployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employee,
			@PathVariable(name = "id") long id) {
		return new ResponseEntity<EmployeeDto>(employeeService.updateEmployee(employee, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted sucessfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/department")
	public List<Map<String, Object>> joinEmpDept() throws SQLException {
		return employeeService.joinEmpDept();
	}

	@GetMapping("/contact")
	public List<Map<String, Object>> joinEmpCon() throws SQLException {
		return employeeService.joinEmpCon();
	}

	@GetMapping(value = { "/department/contact", "/contact/department" })
	public List<Map<String, Object>> joinEmpDeptCon() throws SQLException {
		return employeeService.joinEmpCon();
	}

}
