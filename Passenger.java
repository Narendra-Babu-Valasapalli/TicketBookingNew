package com.example.BusTicketBooking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Passenger {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	private String passengerName;
	private String passengerPassword;
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerPassword() {
		return passengerPassword;
	}
	public void setPassengerPassword(String passengerPassword) {
		this.passengerPassword = passengerPassword;
	}
	@Override
	public String toString() {
		return "Passenger [pId=" + pId + ", passengerName=" + passengerName + ", passengerPassword=" + passengerPassword
				+ "]";
	}
	public Passenger(Integer pId, String passengerName, String passengerPassword) {
		super();
		this.pId = pId;
		this.passengerName = passengerName;
		this.passengerPassword = passengerPassword;
	}
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
