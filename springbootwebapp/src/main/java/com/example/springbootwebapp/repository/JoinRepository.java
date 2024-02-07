package com.example.springbootwebapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class JoinRepository {

	@Autowired
	private JdbcTemplate template;

	public SqlRowSet joinEmpDept() {
		String sql = "select * from employee_details e inner join dept d on " + "e.dept_id=d.dept_id";
		return template.queryForRowSet(sql);

	}

	public SqlRowSet joinEmpCon() {
		String sql = "select * from employee_details e inner join contact_info c on " + "e.employee_id=c.employee_id";
		return template.queryForRowSet(sql);

	}

	public SqlRowSet joinEmpDeptCon() {
		String sql = "select * from employee_details e inner join dept d on " + "e.dept_id=d.dept_id"
				+ " inner join contact_info c on e.employee_id=c.employee_id;";
		return template.queryForRowSet(sql);
	}
}
