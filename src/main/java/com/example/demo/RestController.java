package com.example.demo;

import java.security.spec.DSAGenParameterSpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.aspectj.weaver.bcel.AtAjAttributes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/AU";
    private static final String dbUsername = "root";
    private static final String dbPassword = "pass@123";	
    
    public static DriverManagerDataSource getDataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  dataSource.setDriverClassName(driverClassName);
	  dataSource.setUrl(url);
	  dataSource.setUsername(dbUsername);
	  dataSource.setPassword(dbPassword);
	  return dataSource;
    }
	JdbcTemplate template = new JdbcTemplate(getDataSource());

//	@GetMapping("/get-all-records")
//	public String getAllRecords(){
//		
//	}
	@PostMapping("/insert")
	public String insert(@RequestBody Opportunity op) {
		//System.out.println(op);
		String queryString="Insert into opportunity(opp_name,manager"+
							",creator,creator_email,experience,skills,last_updated)"
							+ "values(?,?,?,?,?,?,?);";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		//System.out.println(dateFormat.format(date));
		template.update(queryString,op.getOppName(),op.getManager(),op.getOppCreator(),op.getOppEmail(),op.getExpInYrs(),op.getSkills(),dateFormat.format(date));
		return "Success";
	}
	@PostMapping("/update")
	public String update(@RequestBody Opportunity op) {
		String queryString="update opportunity set "
				+ "opp_name=?,manager=?"+
				",creator=?,creator_email=?,experience=?,skills=?,last_updated=?"
				+ " where id=?;";
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		//System.out.println(dateFormat.format(date));
		template.update(queryString,op.
				getOppName(),
				op.getManager(),
				op.getOppCreator(),
				op.getOppEmail(),
				op.getExpInYrs(),
				op.getSkills(),
				dateFormat.format(date),
				op.getId());
		return "Success";
	}
	
	@GetMapping("/delete-opp/{id}")
	public String deleteRecord(@PathVariable long id) {
		String queryString="delete from opportunity where id =?";
		template.update(queryString,id);
		return "Success";
	}
	@GetMapping("/get-opp/{id}")
	public Opportunity getRecord(@PathVariable long id) {
		String queryString="select * from opportunity where id =?";
		return template.queryForObject(queryString,new Object[] {id},new OpportunityRowMapper());
	}
	
	@PostMapping("/add-user")
	public int addUser(@RequestBody User user) {
		String queryString="Insert into login(name,email,password) "
				+ "values(?,?,?);";
		return template.update(queryString,user.getName(),user.getEmail(),user.getPassword());
	}
	@PostMapping("/delete-user")
	public String deleteUser(@RequestBody User user) {
		String queryString="delete from login where email =?";
		template.update(queryString,user.getEmail());
		return "Success";
	}
//     System.out.format("There are %d cars in the table", numOfCars);
//	@PostMapping("/add-opportunity")
//	public int saveOpportunity(Opportunity e){  
//	    String query="insert into Opportunity values(  
//	    '"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";  
//	    return jdbcTemplate.update(query);  
//	}  
//	public int updateOpportunity(Opportunity e){  
//	    String query="update Opportunity set   
//	    name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";  
//	    return jdbcTemplate.update(query);  
//	}  
//	public int deleteOpportunity(Opportunity e){  
//	    String query="delete from Opportunity where id='"+e.getId()+"' ";  
//	    return jdbcTemplate.update(query);  
//	}  
}
