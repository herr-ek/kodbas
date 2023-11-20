package se.oakstone.logwatch.dao;

import java.util.List;

import se.oakstone.logwatch.Logfile;

public interface LogfileDAO extends GenericDAO<Logfile, String> {
	public List<Logfile> findAll();
}
