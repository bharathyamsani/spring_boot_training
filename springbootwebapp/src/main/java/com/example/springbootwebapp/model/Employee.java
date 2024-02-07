package com.example.springbootwebapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee_Details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String LastName;
	@Column(name = "email")
	private String email;
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department dept;

	public Employee() {
		super();
	}

	public Employee(long id, String firstName, String lastName, String email, Department dept) {
		super();
		this.employeeId = id;
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.dept = dept;
	}

	public long getId() {
		return employeeId;
	}

	public void setId(long id) {
		this.employeeId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
