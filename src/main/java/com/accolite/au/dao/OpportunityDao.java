package com.accolite.au.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.accolite.au.model.Opportunity;


@Repository
public interface OpportunityDao {
	public List<Opportunity> getAllOpportunity();
	public boolean deleteOpportunity(int id);
	public boolean updateOpportunity(Opportunity op);
	public boolean insertOpportunity(Opportunity op);
	public Opportunity getOpportunity(int id);
}
