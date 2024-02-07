package com.example.springbootwebapp.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.springbootwebapp.model.Department;
import com.example.springbootwebapp.service.DepartmentService;
import com.example.springbootwebapp.service.EmployeeService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping()
	public ResponseEntity<Department> saveEmployee(@RequestBody Department d) {
		return new ResponseEntity<Department>(departmentService.addDepartment(d), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Department> getAllEMployees() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable(name = "id") long id) {
		return new ResponseEntity<Department>(departmentService.getDepartmentById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Department> updateEmployee(@RequestBody Department d, @PathVariable(name = "id") long id) {
		return new ResponseEntity<Department>(departmentService.updateDepartment(id, d), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") long id) {
		departmentService.deleteDepartment(id);
		return new ResponseEntity<String>("Employee deleted sucessfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/employee")
	public List<Map<String, Object>> joinEmpDept() throws SQLException {
		return employeeService.joinEmpDept();
	}

	@GetMapping(value = { "/employee/contact", "/contact/employee" })
	public List<Map<String, Object>> joinEmpDeptCon() throws SQLException {
		return employeeService.joinEmpDeptCon();
	}

}
