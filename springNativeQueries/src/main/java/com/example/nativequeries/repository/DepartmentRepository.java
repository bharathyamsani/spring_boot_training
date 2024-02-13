package com.example.nativequeries.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.nativequeries.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	@Query(value = "select e.emp_name,d.dept_name from employee e inner join department d on e.dept_id=d.dept_id", nativeQuery = true)
	Collection<Object> deptJoinEmp();

}
