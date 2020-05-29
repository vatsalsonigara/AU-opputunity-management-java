package com.example.demo;

public class Opportunity {
	
	private String oppName,manager,oppCreator,oppEmail,skills;
	private int expInYrs;
	private long id;
	private String lastUpdated;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOppName() {
		return oppName;
	}
	public void setOppName(String oppName) {
		this.oppName = oppName;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getOppCreator() {
		return oppCreator;
	}
	public void setOppCreator(String oppCreator) {
		this.oppCreator = oppCreator;
	}
	public String getOppEmail() {
		return oppEmail;
	}
	public void setOppEmail(String oppEmail) {
		this.oppEmail = oppEmail;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getExpInYrs() {
		return expInYrs;
	}
	public void setExpInYrs(int expInYrs) {
		this.expInYrs = expInYrs;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated=lastUpdated;
	}
	@Override
	public String toString() {
		return "Opportunity [oppName=" + oppName + ", manager=" + manager + ", oppCreator=" + oppCreator + ", oppEmail="
				+ oppEmail + ", skills=" + skills + ", expInYrs=" + expInYrs + ", id=" + id + ", lastUpdated="
				+ lastUpdated + "]";
	}
}
