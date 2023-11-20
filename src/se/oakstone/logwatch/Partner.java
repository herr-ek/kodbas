/**
 * 
 */
package se.oakstone.logwatch;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Nils
 * 
 */
@Entity (name="TB_PARTNER")
public class Partner {

	private String partnerId;
	private String partnerName;

	
	@Id
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	public String getPartnerName() {
		return partnerName;
	}
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	
	
}
