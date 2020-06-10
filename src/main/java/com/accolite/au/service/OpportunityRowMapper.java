package com.accolite.au.service;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.accolite.au.model.Opportunity;

@Repository
public class OpportunityRowMapper implements RowMapper<Opportunity>{
	@Override
	public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
	 return new Opportunity(rs.getString("opp_name"),rs.getString("manager"),rs.getString("creator"),rs.getString("creator_email"),rs.getString("skills"),rs.getString("location"),rs.getInt("experience"),rs.getInt("id"),rs.getString("last_updated"));
	}
}