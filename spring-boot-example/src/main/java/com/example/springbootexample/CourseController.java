package com.example.springbootexample;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(new Course(1, "AWS", "ABC"), new Course(2, "DevOps", "ACD"), new Course(3, "Azure", "BCD"),
				new Course(4, "Tomcat", "CDE"));
	}

}
