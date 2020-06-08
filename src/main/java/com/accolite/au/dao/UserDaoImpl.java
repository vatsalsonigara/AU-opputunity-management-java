package com.accolite.au.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.accolite.au.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/AU";
    private static final String dbUsername = "root";
    private static final String dbPassword = "pass@123";	
    private static Map<String, String> tokenMapper =new HashMap<>(); 
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
	public int signIn(User user) {
		String queryString="Insert ignore into login(name,email) "
				+ "values(?,?);";
		return template.update(queryString,user.getName(),user.getEmail());
	}

	@Override
	public void signOut(User user) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public boolean deleteUser(User user) {
		String queryString="delete from login where email =?";
		template.update(queryString,user.getEmail());
		return true;
	}

}
