package se.oakstone.logwatch.dao;

import java.util.List;

import se.oakstone.logwatch.Logfile;

public class LogfileDAOImpl extends GenericDAOImpl<Logfile, String> implements LogfileDAO {

	public List<Logfile> findAll() {
		return findAll(Logfile.class);
	}

}
