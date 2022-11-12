package com.bookbus.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookbus.dto.ReservationDto;
import com.bookbus.exceptions.BusNotFoundException;
import com.bookbus.exceptions.LogException;
import com.bookbus.exceptions.ReservationNotFoundException;
import com.bookbus.models.Reservation;
import com.bookbus.services.ReservationService;

@RestController
@RequestMapping("/cloudbus")
public class ReservationController {
	
	@Autowired
	private ReservationService resService;
	
	
	@PostMapping("/reservatons/{userId}/{busId}")
	public ResponseEntity<Reservation> addReservation(@PathVariable("userId") Integer userId, @PathVariable("busId") Integer busId,@RequestBody ReservationDto reservation) throws BusNotFoundException, LogException {
		Reservation savedReservation=resService.addReservation(userId,busId,reservation);
		return new ResponseEntity<Reservation>(savedReservation,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/reservatons/{userId}/{busId}")
	public ResponseEntity<Reservation> updateReservation(@PathVariable("userId") Integer userId, @PathVariable("busId") Integer busId, @RequestBody ReservationDto reservation) throws ReservationNotFoundException, BusNotFoundException, LogException {
		Reservation updatedReservation=resService.updateReservation(userId,busId,reservation);
		return new ResponseEntity<Reservation>(updatedReservation,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/reservatons/{userId}/{reservationId}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("userId") Integer userId, @PathVariable("reservationId") Integer reservationId) throws ReservationNotFoundException, LogException {
		Reservation deletedReservation=resService.deleteReservation(userId, reservationId);
		return new ResponseEntity<Reservation>(deletedReservation,HttpStatus.OK);
	}
	
	
	@GetMapping("/reservatons/{id}")
	public  ResponseEntity<Reservation> viewReservation(@PathVariable("id") Integer reservationId) throws ReservationNotFoundException {
		Reservation viewReservation=resService.viewReservation(reservationId);
		return new ResponseEntity<Reservation>(viewReservation,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/reservatons/{adminId}")
	public ResponseEntity<List<Reservation>> viewAllReservation(@PathVariable("adminId") Integer adminId) throws ReservationNotFoundException, LogException{
		List<Reservation> allReservations=resService.viewAllReservation(adminId);
		return new ResponseEntity<List<Reservation>>(allReservations,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/allreservatons/{date}")
	public ResponseEntity<List<Reservation>> getAllReservation(@PathVariable("date") String reservationDate) throws ReservationNotFoundException{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ld=LocalDate.parse(reservationDate,dtf);
		List<Reservation> allReservationsByDate=resService.getAllReservation(ld);
		return new ResponseEntity<List<Reservation>>(allReservationsByDate,HttpStatus.CREATED);
	}
}
