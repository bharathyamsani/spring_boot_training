package com.example.webapp.pojo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	public ToDoService todo;

	public ToDoController(ToDoService todo) {
		super();
		this.todo = todo;
	}
//	
//	@RequestMapping("to-dos")
//	public String manageToDo(Model) {
//		
//	}
}
