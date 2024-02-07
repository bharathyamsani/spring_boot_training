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

import com.example.springbootwebapp.model.Contact;
import com.example.springbootwebapp.service.ContactService;
import com.example.springbootwebapp.service.EmployeeService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}

	@GetMapping("{id}")
	public ResponseEntity<Contact> getContact(@PathVariable(name = "id") long id) {
		return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Contact> saveContact(@RequestBody Contact c) {
		return new ResponseEntity<>(contactService.saveContact(c), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable(name = "id") long id, Contact c) {
		return new ResponseEntity<>(contactService.updateContact(id, c), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContact(long id) {
		contactService.deleteContact(id);
		return new ResponseEntity<>("Row deleted successfully!", HttpStatus.OK);
	}

	@GetMapping("/employee")
	public List<Map<String, Object>> joinEmpCon() throws SQLException {
		return employeeService.joinEmpCon();
	}

	@GetMapping(value = { "/department/employee", "/employee/department" })
	public List<Map<String, Object>> joinEmpDeptCon() throws SQLException {
		return employeeService.joinEmpDeptCon();
	}
}