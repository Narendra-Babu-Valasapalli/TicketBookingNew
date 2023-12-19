package com.example.BusTicketBooking.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class BusTicketDto {
	private Integer pTktNo;
	private String pName;
	private String pOrigin;
	public String getpOrigin() {
		return pOrigin;
	}
	public void setpOrigin(String pOrigin) {
		this.pOrigin = pOrigin;
	}
	private String pAge;
	private String pMnum;
	
	private String pDestination;
	public Integer getpTktNo() {
		return pTktNo;
	}
	public void setpTktNo(Integer pTktNo) {
		this.pTktNo = pTktNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpAge() {
		return pAge;
	}
	public void setpAge(String pAge) {
		this.pAge = pAge;
	}
	public String getpMnum() {
		return pMnum;
	}
	public void setpMnum(String pMnum) {
		this.pMnum = pMnum;
	}
	public String getpDestination() {
		return pDestination;
	}
	public void setpDestination(String pDestination) {
		this.pDestination = pDestination;
	}
	@Override
	public String toString() {
		return "BusTicket [pTktNo=" + pTktNo + ", pName=" + pName + ", pOrigin=" + pOrigin + ", pAge=" + pAge
				+ ", pMnum=" + pMnum + ", pDestination=" + pDestination + "]";
	}
	
	public BusTicketDto(Integer pTktNo, String pName, String pOrigin, String pAge, String pMnum, String pDestination) {
		super();
		this.pTktNo = pTktNo;
		this.pName = pName;
		this.pOrigin = pOrigin;
		this.pAge = pAge;
		this.pMnum = pMnum;
		this.pDestination = pDestination;
	}
	
	
	public BusTicketDto() {
		super();
		
	}
	
	
}
