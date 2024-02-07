package com.example.webapp.login;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authservice;
	
	public LoginController(AuthenticationService authservice) {
		this.authservice = authservice;
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(ModelMap model) {
		return "loginPage";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String WelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model) {
		if(authservice.authenticate(name, password)) {
			model.put("name",name);
			model.put("password", password);
			return "welcomePage";
		}
		model.put("errorMessage", "Invalid Credentials");
		return "loginPage";
	}

}
