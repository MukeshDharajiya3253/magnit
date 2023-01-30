package com.emp.happiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={
		"com.emp.*"
})
@SpringBootApplication
public class EmpHappinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpHappinessApplication.class, args);
	}

}
