package com.accolite.au.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.accolite.au.exception.ResourceNotFoundException;
import com.accolite.au.model.Opportunity;
import com.accolite.au.model.User;
import com.accolite.au.service.OpportunityRowMapper;

@Repository
public class OpportunityDaoImpl implements OpportunityDao {

	@Autowired
	private JdbcTemplate template;

	@Override
	public List<Opportunity> getAllOpportunity() {
		String querString="Select * from opportunity;";
		return template.query(querString, new Object[] {},new OpportunityRowMapper());
	}
	
	@Override
	public boolean deleteOpportunity(int id) {
		String queryString="delete from opportunity where id =?";
		template.update(queryString,id);
		return true;
	}

	@Override
	public boolean updateOpportunity(Opportunity op) {
		String queryString="update opportunity set "
				+ "opp_name=?,location=?,manager=?"+
				",creator=?,creator_email=?,experience=?,skills=?,last_updated=?"
				+ " where id=?;";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		template.update(queryString,
				op.getOppName(),
				op.getLocation(),
				op.getManager(),
				op.getOppCreator(),
				op.getOppEmail(),
				op.getExpInYrs(),
				op.getSkills(),
				dateFormat.format(date),
				op.getId());
		return true;
	}

	@Override
	public boolean insertOpportunity(Opportunity op) {
		String queryString="Insert into opportunity(opp_name,location,manager"+
				",creator,creator_email,experience,skills,last_updated)"
				+ "values(?,?,?,?,?,?,?,?);";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		template.update(queryString,op.getOppName(),op.getLocation(),op.getManager(),op.getOppCreator(),op.getOppEmail(),op.getExpInYrs(),op.getSkills(),dateFormat.format(date));
		return true;
	}

	@Override
	public Opportunity getOpportunity(int id) throws ResourceNotFoundException {
		String queryString="select * from opportunity where id =?";
		List<Opportunity> resList=template.query(queryString,new Object[] {id},new OpportunityRowMapper());
		if(resList.isEmpty())throw new ResourceNotFoundException("Opportunity not found");
		else return resList.get(0);
	}
	

}
