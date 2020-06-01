package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OpportunityRowMapper implements RowMapper<Opportunity>{

	@Override
	public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Opportunity op = new Opportunity();
		op.setId(rs.getInt("id"));
		op.setLocation(rs.getString("location"));
		op.setOppName(rs.getString("opp_name"));
		op.setExpInYrs(rs.getInt("experience"));
		op.setLastUpdated(rs.getString("last_updated"));
		op.setManager(rs.getString("manager"));
		op.setOppCreator(rs.getString("creator"));
		op.setOppEmail(rs.getString("creator_email"));
		op.setLastUpdated(rs.getString("last_updated"));
		op.setSkills(rs.getString("skills"));
		return op;
	}

}
