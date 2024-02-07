package com.example.webapp.pojo;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	public static  List<ToDo> todos=new ArrayList<>();
	
	static {
		todos.add(new ToDo(1,"Bharath","Learn Abc",LocalDate.now().plusDays(100),false));
		todos.add(new ToDo(2,"Bharath","Learn BCD",LocalDate.now().plusDays(100),false));
		todos.add(new ToDo(3,"Bharath","Learn CDE",LocalDate.now().plusDays(100),false));
	}
	
	public List<ToDo> findByUsername(String username){
		return todos;
	}
}
