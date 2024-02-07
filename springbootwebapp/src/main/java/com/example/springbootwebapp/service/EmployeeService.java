package com.example.springbootwebapp.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.example.springbootwebapp.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto saveEmployee(EmployeeDto e);

	List<EmployeeDto> getAllEmployees();

	EmployeeDto getEmployeeById(long id);

	EmployeeDto updateEmployee(EmployeeDto e, long id);

	void deleteEmployee(long id);

	boolean hasEmployee(long id);

	List<Map<String, Object>> getList(SqlRowSet rs) throws SQLException;

	List<Map<String, Object>> joinEmpDept() throws SQLException;

	List<Map<String, Object>> joinEmpCon() throws SQLException;

	List<Map<String, Object>> joinEmpDeptCon() throws SQLException;
}
