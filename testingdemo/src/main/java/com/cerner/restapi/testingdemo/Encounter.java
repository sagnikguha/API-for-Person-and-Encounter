package com.cerner.restapi.testingdemo;

import java.util.Date;

public class Encounter {
	
	private String status;
	private int activeInd;
	private long encntrId;
	private long encntrTypeCd;
	private Date registrationDate;
	private Date dischargeDate;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public long getEncntrId() {
		return encntrId;
	}

	public void setEncntrId(long encntrId) {
		this.encntrId = encntrId;
	}

	public long getEncntrTypeCd() {
		return encntrTypeCd;
	}

	public void setEncntrTypeCd(long encntrTypeCd) {
		this.encntrTypeCd = encntrTypeCd;
	}

	public int getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(int activeInd) {
		this.activeInd = activeInd;
	}

}
