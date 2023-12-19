package com.example.BusTicketBooking.Dto;

public class PassengerDto {
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
	public PassengerDto(Integer pId, String passengerName, String passengerPassword) {
		super();
		this.pId = pId;
		this.passengerName = passengerName;
		this.passengerPassword = passengerPassword;
	}
	public PassengerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
