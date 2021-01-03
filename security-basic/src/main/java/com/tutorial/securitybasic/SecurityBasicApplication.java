package com.tutorial.securitybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tutorial.controllers")
public class SecurityBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityBasicApplication.class, args);
	}

}
