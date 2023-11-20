package se.oakstone.logwatch.actions;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;


import com.opensymphony.xwork2.Preparable;

import se.oakstone.logwatch.Logfile;
import se.oakstone.logwatch.Partner;
import se.oakstone.logwatch.dao.HibernateUtil;
import se.oakstone.logwatch.dao.LogfileDAO;
import se.oakstone.logwatch.dao.LogfileDAOImpl;
import se.oakstone.logwatch.dao.PartnerDAO;
import se.oakstone.logwatch.dao.PartnerDAOImpl;

public class LogfileListAction extends BaseAction implements Preparable {
	private static final long serialVersionUID = 1749343078791201340L;

	private List<Logfile> logfiles; 
	private Date minDate;
	private Date maxDate;
	
	private String senderPartner;
	private String receiverPartner;
	private String filename;

	private List<Partner> partners;
	
	@Override
	public String myExecute() {
		
		LogfileDAO logfileDAO = new LogfileDAOImpl();
		Calendar maxCal = Calendar.getInstance();

		try {
			StringBuffer hql = new StringBuffer("from com.pipechain.logwatch.Logfile where 1 = 1 ");
			if (minDate != null) {
				hql.append(" and currentDateTime >= :minDate ");
			}
			if (maxDate != null) {
				maxCal.setTime(maxDate);
				if (maxCal.get(Calendar.HOUR_OF_DAY) == 0 &&
						maxCal.get(Calendar.MINUTE) == 0 &&
						maxCal.get(Calendar.SECOND) == 0 &&
						maxCal.get(Calendar.MILLISECOND) == 0)  {
							// Interpret this as time not set and set it to 23:59:59.999
							maxCal.set(Calendar.HOUR_OF_DAY, 23);
							maxCal.set(Calendar.MINUTE, 59);
							maxCal.set(Calendar.SECOND, 59);
							maxCal.set(Calendar.MILLISECOND, 999);
						}
				hql.append(" and currentDateTime <= :maxDate ");
			}
			if (senderPartner != null && senderPartner.trim().length() > 0) {
				hql.append(" and senderName = :senderName ");
			}		
			if (receiverPartner != null && receiverPartner.trim().length() > 0) {
				hql.append(" and receiverName = :receiverName ");
			}		
			if (filename != null && filename.trim().length() > 0) {
				hql.append(" and (orgFileName = :orgFileName or VFDescription = :orgFileName)");
			}
			
			
			hql.append(" Order by currentDateTime desc");
			
			HibernateUtil.beginTransaction();
			Query query = HibernateUtil.getSession().createQuery(hql.toString());
			if (minDate != null) {
				query.setTimestamp("minDate", minDate);
			}
			if (maxDate != null) {
				query.setTimestamp("maxDate", new Date(maxCal.getTimeInMillis()));
			}
			if (senderPartner != null && senderPartner.trim().length() > 0) {
				query.setString("senderName", senderPartner);
			}		
			if (receiverPartner != null && receiverPartner.trim().length() > 0) {
				query.setString("receiverName", receiverPartner);
			}		
			if (filename != null && filename.trim().length() > 0) {
				query.setString("orgFileName", filename);
			}	
			
			
			query.setMaxResults(500);
			logfiles = logfileDAO.findMany(query);
			

			
			HibernateUtil.commitTransaction();
		}
		finally {
			HibernateUtil.getSession().close();
		}
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		PartnerDAO partnerDAO = new PartnerDAOImpl();

		try {
			
			HibernateUtil.beginTransaction();
			
			partners = partnerDAO.findAll();  
			
			
			HibernateUtil.commitTransaction();
		}
		finally {
			HibernateUtil.getSession().close();
		}
	}
	
	
	public List<Logfile> getLogfiles() {
		return logfiles;
	}

	public Date getMinDate() {
		return minDate;
	}

	public void setMinDate(Date minDate) {
		this.minDate = minDate;
	}

	public Date getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(Date maxDate) {
		this.maxDate = maxDate;
	}


	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<Partner> getPartners() {
		return partners;
	}

	public String getSenderPartner() {
		return senderPartner;
	}

	public void setSenderPartner(String senderPartner) {
		this.senderPartner = senderPartner;
	}

	public String getReceiverPartner() {
		return receiverPartner;
	}

	public void setReceiverPartner(String receiverPartner) {
		this.receiverPartner = receiverPartner;
	}

	@Override
	public String myInput() throws Exception {
		return INPUT;
	}




	
}
