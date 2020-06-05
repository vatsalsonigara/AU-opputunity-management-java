package DAO;

import Model.User;

public interface UserDao {
	public int signIn(User user ); //includes insert
	public void signOut(User user);
	public boolean deleteUser(User user);
}
