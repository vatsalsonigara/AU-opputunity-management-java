package com.accolite.au.model;

import org.springframework.stereotype.Repository;


public class Opportunity {
	
	private String oppName,manager,oppCreator,oppEmail,skills,location;
	private int expInYrs;
	private long id;
	private String lastUpdated;
	public Opportunity() {}
	public Opportunity(String oppName, String manager, String oppCreator, String oppEmail, String skills,
			String location, int expInYrs, long id, String lastUpdated) {
		super();
		this.oppName = oppName;
		this.manager = manager;
		this.oppCreator = oppCreator;
		this.oppEmail = oppEmail;
		this.skills = skills;
		this.location = location;
		this.expInYrs = expInYrs;
		this.id = id;
		this.lastUpdated = lastUpdated;
	}
	public String getLocation() {
		return location;
	}
	
	public long getId() {
		return id;
	}
	
	public String getOppName() {
		return oppName;
	}
	public String getManager() {
		return manager;
	}

	public String getOppCreator() {
		return oppCreator;
	}

	public String getOppEmail() {
		return oppEmail;
	}

	public String getSkills() {
		return skills;
	}

	public int getExpInYrs() {
		return expInYrs;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}
	
}
