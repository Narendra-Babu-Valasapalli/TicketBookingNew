package com.example.BusTicketBooking.Service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BusTicketBooking.Entity.BusTicket;
import com.example.BusTicketBooking.Entity.Passenger;
import com.example.BusTicketBooking.Exception.TicketException;
import com.example.BusTicketBooking.Repository.PassengerRepository;
@Service(value = "PassengerService")
public class PassengerServiceImpl implements PassengerService {
@Autowired
private PassengerRepository prepo;
	@Override
	public String addUserName(Passenger passenger) {
		
		Passenger p = new Passenger();
		
		p.setPassengerName(passenger.getPassengerName());
		p.setPassengerPassword(passenger.getPassengerPassword());
		
		prepo.save(p);
		return "User added successfully";
	}
	@Override
	public Passenger updateUserById(Integer pId, Passenger passenger) throws TicketException {

		Optional<Passenger> opt = prepo.findById(pId);
	Passenger p1 = opt.orElseThrow(() -> new TicketException(" no passenger found with id " +pId));
		
	Passenger p = 	prepo.findById(pId).get();
	
	if(Objects.nonNull(passenger.getPassengerName())&&!"".equalsIgnoreCase(passenger.getPassengerName())) {
		p.setPassengerName(passenger.getPassengerName());
		
	}
	if(Objects.nonNull(passenger.getPassengerPassword())&&!"".equalsIgnoreCase(passenger.getPassengerPassword())) {
		p.setPassengerPassword(passenger.getPassengerPassword());
		
	}
	
	prepo.save(p);
		return p;
	}
	@Override
	public void deleteById(Integer pId, Passenger passenger) throws TicketException {
		
		Optional<Passenger> opt = prepo.findById(pId);
	Passenger p = opt.orElseThrow(() -> new TicketException(" no passenger found with id " +pId));
		
	  prepo.delete(p);
	 
		
	}
	

}
