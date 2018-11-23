package com.cerner.restapi.testingdemo;

public class Person {
	
	private String status = null ;
	private Integer activeInd = 0 ;
	private Integer personId = 0;
	private String nameFirst = null ;
	private String nameLast = null ;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    public Integer getActiveInd() {
		return activeInd;
	}
	public void setActiveInd(Integer activeInd) {
		this.activeInd = activeInd;
	}
	public String getNameFirst() {
		return nameFirst;
	}
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}
	public String getNameLast() {
		return nameLast;
	}
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}
    public Integer getPersonId() {
        return personId;
    }
	public void setPersonId(Integer id) {
		this.personId = id;
	}	
}	
