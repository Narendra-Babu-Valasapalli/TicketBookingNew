package com.example.BusTicketBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BusTicketBooking.Entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{


}
