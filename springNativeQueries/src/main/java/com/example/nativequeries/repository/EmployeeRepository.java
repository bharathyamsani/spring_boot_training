package com.example.nativequeries.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.nativequeries.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from employee where emp_name=:name", nativeQuery = true)
	Collection<Employee> getEmployeesByName(@Param(value = "name") String name);

	@Query(value = "select * from employee where salary>:sal", nativeQuery = true)
	Collection<Employee> empWithSalGreater(@Param(value = "sal") float sal);

	@Query(value = "select e.emp_id,e.emp_name,e.salary,e.phone_no,e.dept_id,d.dept_name from employee e right join department d on e.dept_id=d.dept_id where d.dept_name=:dept", nativeQuery = true)
	Collection<Employee> empJoinDept(@Param(value = "dept") String dept);

	@Query(value = "select * from employee order by salary desc", nativeQuery = true)
	Collection<Employee> sortBySal();

	@Query(value = "select avg(salary) from employee", nativeQuery = true)
	Float avgSal();

}
