package com.example.BusTicketBooking.Service;

import com.example.BusTicketBooking.Entity.Passenger;
import com.example.BusTicketBooking.Exception.TicketException;

public interface PassengerService {

	
	public String addUserName(Passenger passenger) ;
	
	public Passenger updateUserById (Integer pId , Passenger passenger) throws TicketException;
	
	public void deleteById(Integer pId , Passenger passenger) throws TicketException;
}
