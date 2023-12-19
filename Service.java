package com.example.BusTicketBooking.Service;

import java.util.List;

import com.example.BusTicketBooking.Dto.BusTicketDto;
import com.example.BusTicketBooking.Entity.BusTicket;
import com.example.BusTicketBooking.Exception.TicketException;

public interface Service {
  
	public String addPassenger(BusTicketDto Dto) throws TicketException;
	
	public BusTicket updatePassenger(   Integer pTktNo , BusTicket busticket) throws TicketException;
	
	public BusTicketDto viewPassenger(Integer pTktNo) throws TicketException;
	
	 public List<BusTicket> viewAllPassengers();
	 
	 public void deletePassengerById(Integer pTktNo) throws TicketException;
	 
	 
	 BusTicket fetchPassengerBypName(String pName) throws TicketException;
	 
	 BusTicket fetchPassengersBypAge(String pAge) throws TicketException;
	 
	 BusTicket fetchPassengersBypDestinationIgnoreCase(String pDestination) throws TicketException;
	 
	 
	 BusTicket fetchPassengersBypOrigin(String pOrigin) throws TicketException;
}
