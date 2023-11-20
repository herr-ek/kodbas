/**
 * 
 */
package se.oakstone.logwatch;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Nils
 * 
 */
@Entity (name="TB_LOGFILE")
public class Logfile {

	private String jobCnt;

	private Timestamp addedToDb;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Timestamp currentDateTime;
	
	private String logicalFileId;
	private String senderCode;
	private String senderQual;
	private String senderRouting;
	private String receiverCode;
	private String receiverQual;
	private String receiverRouting;
	private String orgFileName;
	private String orgFileExtension;
	private String VFN;
	private String VFDescription;
	
	
	private Timestamp sentDateTime;
	
	private String status;
	private String size;
	private String jobError;

	private Partner receiverPartner;
	private Partner senderPartner;
	
	@Id
	public String getJobCnt() {
		return jobCnt;
	}
	public void setJobCnt(String jobCnt) {
		this.jobCnt = jobCnt;
	}
	
	public Timestamp getAddedToDb() {
		return addedToDb;
	}
	public void setAddedToDb(Timestamp addedToDb) {
		this.addedToDb = addedToDb;
	}

	public Timestamp getCurrentDateTime() {
		return currentDateTime;
	}
	public void setCurrentDateTime(Timestamp currentDateTime) {
		this.currentDateTime = currentDateTime;
	}
	public String getLogicalFileId() {
		return logicalFileId;
	}
	public void setLogicalFileId(String logicalFileId) {
		this.logicalFileId = logicalFileId;
	}
	/*
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	*/
	public String getSenderCode() {
		return senderCode;
	}
	public void setSenderCode(String senderCode) {
		this.senderCode = senderCode;
	}
	public String getSenderQual() {
		return senderQual;
	}
	public void setSenderQual(String senderQual) {
		this.senderQual = senderQual;
	}
	public String getSenderRouting() {
		return senderRouting;
	}
	public void setSenderRouting(String senderRouting) {
		this.senderRouting = senderRouting;
	}
	
/*	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	*/
	public String getReceiverCode() {
		return receiverCode;
	}
	public void setReceiverCode(String receiverCode) {
		this.receiverCode = receiverCode;
	}
	public String getReceiverQual() {
		return receiverQual;
	}
	public void setReceiverQual(String receiverQual) {
		this.receiverQual = receiverQual;
	}
	public String getReceiverRouting() {
		return receiverRouting;
	}
	public void setReceiverRouting(String receiverRouting) {
		this.receiverRouting = receiverRouting;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getOrgFileExtension() {
		return orgFileExtension;
	}
	public void setOrgFileExtension(String orgFileExtension) {
		this.orgFileExtension = orgFileExtension;
	}
	public String getVFN() {
		return VFN;
	}
	public void setVFN(String vFN) {
		VFN = vFN;
	}
	public String getVFDescription() {
		return VFDescription;
	}
	public void setVFDescription(String vFDescription) {
		VFDescription = vFDescription;
	}
	public Timestamp getSentDateTime() {
		return sentDateTime;
	}
	public void setSentDateTime(Timestamp sentDateTime) {
		this.sentDateTime = sentDateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getJobError() {
		return jobError;
	}
	public void setJobError(String jobError) {
		this.jobError = jobError;
	}
	
	@ManyToOne 
	@JoinColumn(name = "receiverName")
	public Partner getReceiverPartner() {
		return receiverPartner;
	}
	public void setReceiverPartner(Partner receiverPartner) {
		this.receiverPartner = receiverPartner;
	}
	
	@ManyToOne 
	@JoinColumn(name = "senderName")
	public Partner getSenderPartner() {
		return senderPartner;
	}
	public void setSenderPartner(Partner senderPartner) {
		this.senderPartner = senderPartner;
	}
	
	
	
}
