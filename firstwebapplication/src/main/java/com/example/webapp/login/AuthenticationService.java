package com.example.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String name,String password) {
		return name.equals("Bharath") && password.equals("12345");
	}

}
