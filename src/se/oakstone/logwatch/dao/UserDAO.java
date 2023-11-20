package se.oakstone.logwatch.dao;

import java.util.List;

import se.oakstone.logwatch.User;

public interface UserDAO extends GenericDAO<User, String> {
	public List<User> findAll();
}
