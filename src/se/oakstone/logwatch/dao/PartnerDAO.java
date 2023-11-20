package se.oakstone.logwatch.dao;

import java.util.List;

import se.oakstone.logwatch.Partner;

public interface PartnerDAO extends GenericDAO<Partner, String> {
	public List<Partner> findAll();
}
