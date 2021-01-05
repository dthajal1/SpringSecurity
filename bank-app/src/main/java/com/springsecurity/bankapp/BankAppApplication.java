package com.springsecurity.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScans({
		@ComponentScan("com.springsecurity.controllers"),
		@ComponentScan("com.springsecurity.config")
})
@EnableJpaRepositories("com.springsecurity.repositories")
@EntityScan("com.springsecurity.model")
public class BankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

}
