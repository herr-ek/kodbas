package se.oakstone.logwatch.dao;

import java.util.List;

import se.oakstone.logwatch.User;

public class UserDAOImpl extends GenericDAOImpl<User, String> implements UserDAO {

	public List<User> findAll() {
		return findAll(User.class);
	}

}
