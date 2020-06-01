package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class AuOpportunityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuOpportunityManagementApplication.class, args);
		//JdbcTemplate template;
	}

}
