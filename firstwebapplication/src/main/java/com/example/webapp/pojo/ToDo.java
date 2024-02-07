package com.example.webapp.pojo;

import java.time.LocalDate;

public class ToDo {
	
	private int id;
	private String username;
	private String description;
	private LocalDate dt;
	private boolean todo;
	
	public ToDo(int id, String username, String description, LocalDate dt, boolean todo) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.dt = dt;
		this.todo = todo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDt() {
		return dt;
	}

	public void setDt(LocalDate dt) {
		this.dt = dt;
	}

	public boolean isTodo() {
		return todo;
	}

	public void setTodo(boolean todo) {
		this.todo = todo;
	}

	@Override
	public String toString() {
		return "ToDo [id=" + id + ", username=" + username + ", description=" + description + ", dt=" + dt + ", todo="
				+ todo + "]";
	}
	
	
	
	

}
