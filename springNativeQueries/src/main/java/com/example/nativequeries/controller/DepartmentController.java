package com.example.nativequeries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativequeries.model.Department;
import com.example.nativequeries.service.DepartmentService;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;

	@PostMapping
	public Department addDepartment(@RequestBody Department dept) {
		return deptService.addDepartment(dept);
	}

	@GetMapping
	public List<Department> getDepartments() {
		return deptService.getDepartments();
	}

}
