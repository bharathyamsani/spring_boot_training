package com.example.nativequeries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nativequeries.model.Employee;
import com.example.nativequeries.repository.DepartmentRepository;
import com.example.nativequeries.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;

	@Autowired
	private DepartmentRepository deptRepo;

	@GetMapping
	public List<Employee> getEmployees(@RequestParam(name = "name") String name) {
		return empService.getEmployeesByName(name);
	}

	@GetMapping("all")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@PostMapping
	public Employee addEmployee(@RequestBody Employee e) {
		if (deptRepo.findById(e.getDept().getDeptId()).isPresent()) {
			return empService.addEmployee(e);
		}
		return null;

	}

	@GetMapping("sal")
	public List<Employee> getEmpWithSalGreater(@RequestParam(name = "sal") float sal) {
		return empService.empWithSalGreater(sal);

	}

	@GetMapping("query")
	public List<Employee> empJoinDept(@RequestParam(name = "dept") String dept) {
		return empService.empJoinDept(dept);

	}

	@GetMapping("sort")
	public List<Employee> empSortBySal() {
		return empService.empSortBySal();

	}

	@GetMapping("/avgSal")
	public String getAvgSal() {
		return empService.avgSal();

	}

}
