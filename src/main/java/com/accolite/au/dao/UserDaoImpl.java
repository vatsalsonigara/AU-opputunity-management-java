package com.accolite.au.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.accolite.au.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	JdbcTemplate template ;
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
