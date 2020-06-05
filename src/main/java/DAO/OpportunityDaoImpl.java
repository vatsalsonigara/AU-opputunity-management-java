package DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import Model.Opportunity;
import Model.User;
import Service.OpportunityRowMapper;

public class OpportunityDaoImpl implements OpportunityDao{

	private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/AU";
    private static final String dbUsername = "root";
    private static final String dbPassword = "pass@123";	
    //private static Map<String, String> tokenMapper =new HashMap<>(); 
    public static DriverManagerDataSource getDataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName(driverClassName);
	  dataSource.setUrl(url);
	  dataSource.setUsername(dbUsername);
	  dataSource.setPassword(dbPassword);
	  return dataSource;
    }
	JdbcTemplate template = new JdbcTemplate(getDataSource());
	@Override
	public List<Opportunity> getAllOpportunity() {
		// TODO Auto-generated method stub
		String querString="Select * from opportunity;";
		return template.query(querString, new Object[] {},new OpportunityRowMapper());
		//return null;
	}

	@Override
	public boolean deleteOpportunity(int id) {
		// TODO Auto-generated method stub
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
		//System.out.println(dateFormat.format(date));
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
	public Opportunity getOpportunity(int id) {
		String queryString="select * from opportunity where id =?";
		List<Opportunity> resList=template.query(queryString,new Object[] {id},new OpportunityRowMapper());
		if(resList.isEmpty()) return null;
		else return resList.get(0);
	}
	

}
