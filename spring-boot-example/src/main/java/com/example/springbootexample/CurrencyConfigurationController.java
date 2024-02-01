package com.example.springbootexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class CurrencyConfigurationController {
	@Autowired
	public CurrencyServiceConfiguration cs;

	@GetMapping("/currency-service")
	public CurrencyServiceConfiguration retrieveCurrencyService() {
		return this.cs;
	}

}
