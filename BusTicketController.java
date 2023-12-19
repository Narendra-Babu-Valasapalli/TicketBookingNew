package com.example.BusTicketBooking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BusTicketBooking.Dto.BusTicketDto;
import com.example.BusTicketBooking.Entity.BusTicket;
import com.example.BusTicketBooking.Entity.Passenger;
import com.example.BusTicketBooking.Exception.TicketException;
import com.example.BusTicketBooking.Service.PassengerService;
import com.example.BusTicketBooking.Service.Service;



@RestController
public class BusTicketController {

	@Autowired
	private Service service;
	@Autowired
	private PassengerService pservice;
	
	@PostMapping(value = "/add-passenger")

	public ResponseEntity<?> addpassenger(@RequestBody BusTicketDto dto) throws TicketException {
		return new ResponseEntity<String>(service.addPassenger(dto), HttpStatus.CREATED);

	}

	@PutMapping(value = "/update-passenger/pTktNo/{pTktNo}")

	ResponseEntity<BusTicket> updatePassenger(@PathVariable Integer pTktNo, @RequestBody BusTicket busticket)
			throws Exception {

		BusTicket btt = service.updatePassenger(pTktNo, busticket);
		return new ResponseEntity<BusTicket>(btt, HttpStatus.OK);

	}

	@GetMapping("/get-passenger/{pTktNo}")
	public ResponseEntity<BusTicketDto> getPassenger(@PathVariable("pTktNo") Integer pTktNo) throws TicketException {

		BusTicketDto dt = service.viewPassenger(pTktNo);
		return new ResponseEntity<BusTicketDto>(dt, HttpStatus.OK);
	}

	@GetMapping(value = "/viewAll-passengers")
	public List<BusTicket> viewAllPassengers() {
		return service.viewAllPassengers();
	}

	@DeleteMapping(value = "/delete-passenger/{pTktNo}")

	public String deletePassengerById(@PathVariable("pTktNo") Integer pTktNo) throws TicketException {

		service.deletePassengerById(pTktNo);
		return "Passenger cancelled ticket successfully with ticket no" + " " + pTktNo;

	}
	
	@GetMapping(value = "/passenger/pName/{pName}")
	public BusTicket fetchPassengerByName(@PathVariable("pName") String pName) throws TicketException  {

		return service.fetchPassengerBypName(pName);
}
	@GetMapping(value = "/passengers/pAge/{pAge}")
	public BusTicket fetchPassengersByAge(@PathVariable("pAge") String pAge) throws TicketException  {

		return service.fetchPassengersBypAge(pAge);
	
}
	
	@GetMapping("/Destination/pDestination/{pDestination}")
	public BusTicket fetchPassengersByDestinations(@PathVariable ("pDestination") String pDestination) throws TicketException {
		
		return service.fetchPassengersBypDestinationIgnoreCase(pDestination);
	}
	
	
	
	@GetMapping("/passengers-origin/pOrigin/{pOrigin}")
public BusTicket fetchPassengersByOrigin(@PathVariable ("pOrigin") String pOrigin) throws TicketException {
		
		return service.fetchPassengersBypOrigin(pOrigin);
	}
	
	@PostMapping(value = "/add-username")

	public String addusername(@RequestBody Passenger passenger){
		return pservice.addUserName(passenger);

	}
	@PutMapping(value = "/update-user/pId/{pId}")

	ResponseEntity<Passenger> updateUser(@PathVariable Integer pId, @RequestBody Passenger passenger) throws TicketException{

		Passenger p= pservice.updateUserById(pId, passenger);
		return new ResponseEntity<Passenger>(p, HttpStatus.OK);

	}
	
	@DeleteMapping(value = "/delete-user/{pId}")

	public String deleteUserById(@PathVariable("pId") Integer pId ,  Passenger passenger) throws TicketException{
	
		pservice.deleteById(pId, passenger);
		return "User deleted successfully with id" + " " + pId;

	}
}
