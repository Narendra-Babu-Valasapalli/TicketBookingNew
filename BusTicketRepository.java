package com.example.BusTicketBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.BusTicketBooking.Entity.BusTicket;
import com.example.BusTicketBooking.Exception.TicketException;

public interface BusTicketRepository extends JpaRepository<BusTicket, Integer>{

	public BusTicket findPassengerBypNameIgnoreCase(String pName) throws TicketException;
	
	public BusTicket findPassengersBypAge(String pAge) throws TicketException;
	
	@Query(value = "select * from bus p where p_destination = :p_destination", nativeQuery = true)
	public BusTicket findPassengerBypDestinationIgnoreCase(@Param("p_destination") String pDestination) throws TicketException;
	
  
	public BusTicket findPassengerBypOriginIgnoreCase(String pOrigin) throws TicketException;
}
