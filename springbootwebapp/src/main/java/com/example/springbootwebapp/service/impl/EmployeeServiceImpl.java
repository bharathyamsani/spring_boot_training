package com.example.springbootwebapp.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.example.springbootwebapp.dto.EmployeeDto;
import com.example.springbootwebapp.exception.ResourceNotFoundException;
import com.example.springbootwebapp.model.Employee;
import com.example.springbootwebapp.repository.EmployeeRepository;
import com.example.springbootwebapp.repository.JoinRepository;
import com.example.springbootwebapp.service.DepartmentService;
import com.example.springbootwebapp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private JoinRepository joinRepository;

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
	public List<Map<String, Object>> getList(SqlRowSet rs) throws SQLException {
		List<Map<String, Object>> l = new ArrayList<>();
		String column[] = rs.getMetaData().getColumnNames();
		while (rs.next()) {
			Map<String, Object> mp = new HashMap<String, Object>();
			for (int i = 0; i < column.length; i++) {
				mp.put(column[i], rs.getObject(i + 1));
			}
			l.add(mp);
		}
		return l;
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

	public List<Map<String, Object>> joinEmpDept() throws SQLException {
		return getList(joinRepository.joinEmpDept());
	}

	public List<Map<String, Object>> joinEmpCon() throws SQLException {
		return getList(joinRepository.joinEmpCon());

	}

	public List<Map<String, Object>> joinEmpDeptCon() throws SQLException {
		return getList(joinRepository.joinEmpDeptCon());

	}

}
