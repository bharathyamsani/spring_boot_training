package com.example.webapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String helloTxt() {
		return "Hello";
	}
	
	@RequestMapping("/hello.html")
	@ResponseBody
	public String helloHtml() {
		return "<html>"
				+ "<head>"
				+ "<title>First Web App</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Hello</h1>"
				+ "<p>Welcome to my first web application</p>"
				+ "</body>"
				+ "</html>";
	}
	
	@RequestMapping("/hellopage")
	public String hellJsp() {
		return "hellopage";
	}

}
