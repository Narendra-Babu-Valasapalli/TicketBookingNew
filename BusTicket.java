package com.example.BusTicketBooking.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedNativeQuery(name = "BusTicket.findPassengerBypOriginIgnoreCase",
query = "select * from bus where p_origin = :pOrigin",
resultClass = BusTicket.class)
@Table(name = "Bus")
public class BusTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	public BusTicket(Integer pTktNo, String pName, String pOrigin, String pAge, String pMnum, String pDestination) {
		super();
		this.pTktNo = pTktNo;
		this.pName = pName;
		this.pOrigin = pOrigin;
		this.pAge = pAge;
		this.pMnum = pMnum;
		this.pDestination = pDestination;
	}
	
	
	public BusTicket() {
		super();
		
	}
	
	
	
	
	
}
