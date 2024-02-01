package com.example.firstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello!, what are you learning today!";
	}

	@GetMapping("/hello.html")
	@ResponseBody
	public String helloHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>First Web App</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1> First Web App</h1>");
		sb.append("<p> Hello</p>");
		sb.append("</body>");
		sb.append("<html>");
		return sb.toString();
	}

	@RequestMapping("/hellopage")
	//@ResponseBody
	public String helloJsp() {
		return "hellopage";
	}

}
