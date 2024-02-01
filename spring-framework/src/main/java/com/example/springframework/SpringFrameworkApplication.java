package com.example.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.springframework.game.*;

@SpringBootApplication
public class SpringFrameworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringFrameworkApplication.class, args);
		GameRunner runner=context.getBean(GameRunner.class);
		runner.run();
	}

}
