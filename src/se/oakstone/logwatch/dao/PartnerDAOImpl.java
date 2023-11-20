package se.oakstone.logwatch.dao;

import java.util.List;

import se.oakstone.logwatch.Partner;

public class PartnerDAOImpl extends GenericDAOImpl<Partner, String> implements PartnerDAO {

	public List<Partner> findAll() {
		return findAll(Partner.class, "partnerName asc ");
	}

}
