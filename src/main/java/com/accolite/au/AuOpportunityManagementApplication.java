package com.accolite.au;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Jdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import DAO.OpportunityDaoImpl;

@SpringBootApplication
public class AuOpportunityManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuOpportunityManagementApplication.class, args);
		//JdbcTemplate template;
		//System.out.println(new OpportunityDaoImpl().getAllOpportunity());
	}
	
	
}
