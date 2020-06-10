package com.accolite.au.model;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;


public class User {
	@Getter @Setter private String name,email,token;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	
}
