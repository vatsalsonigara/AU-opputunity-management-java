package com.accolite.au;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource(value = { "classpath:application.properties" })
public class AuOpportunityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuOpportunityManagementApplication.class, args);
		
	}
}
