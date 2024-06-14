package com.project.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.project.principal", "controllers", "models", "repository", "service"})
//@EnableJpaRepositories(basePackages = {"com.project.principal.repository"})
public class BabyCareClinicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BabyCareClinicApplication.class, args);
	}

}
