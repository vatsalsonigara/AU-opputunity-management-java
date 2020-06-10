package com.accolite.au.dao;

import org.springframework.stereotype.Repository;

import com.accolite.au.model.User;

@Repository
public interface UserDao {
	public int signIn(User user ); 
	public void signOut(User user);
	public boolean deleteUser(User user);
}
