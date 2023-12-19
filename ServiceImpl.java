package com.example.BusTicketBooking.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BusTicketBooking.Dto.BusTicketDto;
import com.example.BusTicketBooking.Entity.BusTicket;
import com.example.BusTicketBooking.Entity.Passenger;
import com.example.BusTicketBooking.Exception.TicketException;
import com.example.BusTicketBooking.Repository.BusTicketRepository;

@org.springframework.stereotype.Service(value = "Service")
public class ServiceImpl implements Service {
	@Autowired
	private BusTicketRepository brepo;

	@Override
	public String addPassenger(BusTicketDto Dto) throws TicketException {

		 
		BusTicket bt = new BusTicket();

		bt.setpName(Dto.getpName());
		bt.setpOrigin(Dto.getpOrigin());
		bt.setpAge(Dto.getpAge());
		bt.setpMnum(Dto.getpMnum());
		bt.setpDestination(Dto.getpDestination());

		brepo.save(bt);
		return " Passenger added successfully with ticket no" + " " + bt.getpTktNo();
	}
		

	@Override
	public BusTicketDto viewPassenger(Integer pTktNo) throws TicketException {
		Optional<BusTicket> opt = brepo.findById(pTktNo);
		BusTicket tt = opt.orElseThrow(() -> new TicketException(" no passenger found with ticket number " + pTktNo));

		BusTicketDto dto = new BusTicketDto();

		dto.setpTktNo(tt.getpTktNo());
		dto.setpName(tt.getpName());
		dto.setpOrigin(tt.getpOrigin());
		dto.setpAge(tt.getpAge());
		dto.setpMnum(tt.getpMnum());
		dto.setpDestination(tt.getpDestination());
		return dto;
	}

	@Override
	public List<BusTicket> viewAllPassengers() {

		return brepo.findAll();
	}

	@Override
	public void deletePassengerById(Integer pTktNo) throws TicketException {

		Optional<BusTicket> opt = brepo.findById(pTktNo);
		BusTicket p1 = opt.orElseThrow(() -> new TicketException(" no passenger found with ticket number " +pTktNo));
		BusTicket bt =	brepo.findById(pTktNo).get();
		brepo.deleteById(pTktNo);

	}

	@Override
	public BusTicket fetchPassengerBypName(String pName) throws TicketException {

		Optional<BusTicket> opt = Optional.ofNullable(brepo.findPassengerBypNameIgnoreCase(pName));
		BusTicket tt = opt.orElseThrow(() -> new TicketException(" no passenger found with name " +pName));
		
		return brepo.findPassengerBypNameIgnoreCase(pName);
	}

	@Override
	public BusTicket fetchPassengersBypAge(String pAge) throws TicketException {

		Optional<BusTicket> opt = Optional.ofNullable(brepo.findPassengersBypAge(pAge));
		BusTicket tt = opt.orElseThrow(() -> new TicketException(" no passenger found with age " +pAge));
		return brepo.findPassengersBypAge(pAge);
	}

	@Override
	public BusTicket fetchPassengersBypDestinationIgnoreCase(String pDestination) throws TicketException {

		Optional<BusTicket> opt = Optional.ofNullable(brepo.findPassengerBypDestinationIgnoreCase(pDestination));
		BusTicket tt = opt.orElseThrow(() -> new TicketException(" no passenger found with destination " +pDestination));
		return brepo.findPassengerBypDestinationIgnoreCase(pDestination);
	}

	@Override
	public BusTicket fetchPassengersBypOrigin(String pOrigin) throws TicketException {

		Optional<BusTicket> opt = Optional.ofNullable(brepo.findPassengerBypOriginIgnoreCase(pOrigin));
		BusTicket tt = opt.orElseThrow(() -> new TicketException(" no passenger found with origin " +pOrigin));
	
		return brepo.findPassengerBypOriginIgnoreCase(pOrigin);
	}

	@Override
	public BusTicket updatePassenger(Integer pTktNo, BusTicket busticket) throws TicketException {
		

		Optional<BusTicket> opt = brepo.findById(pTktNo);
	BusTicket p1 = opt.orElseThrow(() -> new TicketException(" no passenger found with ticket number " +pTktNo));
	BusTicket bt =	brepo.findById(pTktNo).get();
		
	if(Objects.nonNull(busticket.getpName())&&!"".equalsIgnoreCase(busticket.getpName())) {
		bt.setpName(busticket.getpName());
		
	}

		
	
	
	if(Objects.nonNull(busticket.getpAge())&&!"".equalsIgnoreCase(busticket.getpAge())) {
		bt.setpAge(busticket.getpAge());
		
	}
	
	if(Objects.nonNull(busticket.getpMnum())&&!"".equalsIgnoreCase(busticket.getpMnum())) {
		bt.setpMnum(busticket.getpMnum());
		
	}
	
	if(Objects.nonNull(busticket.getpOrigin())&&!"".equalsIgnoreCase(busticket.getpOrigin())) {
		bt.setpOrigin(busticket.getpOrigin());
		
	}
	
	if(Objects.nonNull(busticket.getpDestination())&&!"".equalsIgnoreCase(busticket.getpDestination())) {
		bt.setpDestination(busticket.getpDestination());
		
	}
	
	
		return brepo.save(bt);
	}

	

}
