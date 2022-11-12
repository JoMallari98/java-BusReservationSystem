package com.bookbus.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Bus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="busSequence")
//	@SequenceGenerator(name = "busSequence",sequenceName = "bus_Id",allocationSize = 1,initialValue = 51)
	private int busId;
	
//	@NotNull(message = "Bus name not found")
//	@NotBlank(message = "Bus name should not blank")
//	@NotEmpty(message = "Bus name should not empty")
//	@Size(min=3,max = 12,message = "Bus name should be minimum 3 and maximum 12 character")
	private String busName;
	
//	@NotNull(message = "Bus driver name not found")
//	@NotBlank(message = "Bus driver name should not blank")
//	@NotEmpty(message = "Bus driver name should not empty")
//	@Size(min=3,max = 16,message = "Bus driver name should be minimum 3 and maximum 16 character")
	private String driverName;
	
//	@NotNull(message = "Bus type not found")
//	@NotBlank(message = "Bus type should not blank")
//	@NotEmpty(message = "Bus type should not empty")
//	@Size(min=5,max = 12,message = "Bus type should be minimum 5 and maximum 12 character")
	private String busType;
	
//	@NotNull(message = "Source station name not found")
//	@NotBlank(message = "Source station name should not blank")
//	@NotEmpty(message = "Source station name should not empty")
//	@Size(min=3,max = 15,message = "Source station name should be minimum 3 and maximum 15 character")
	private String routeFrom;
	
//	@NotNull(message = "Destination station name not found")
//	@NotBlank(message = "Destination station name should not blank")
//	@NotEmpty(message = "Destination station name should not empty")
//	@Size(min=3,max=15,message = "Destination station name should be minimum 3 and maximum 15 character")
	private String routeTo;
	
//	@Future(message = "Arrival time should be in future")
	private String arrivalTime;
	
//	@Future(message = "Departure time should be in future")
	private String departureTime;
	
	//@Min(value = 0,message = "Minimum seat is 0")
	private Integer seats;
	
	//@Size(min = 0,max = 50,message = "Invalid number of booking or no seat avaiable")
	private Integer avaiableSeats;

	
	public Bus(String busName, String driverName, String busType, String routeFrom, String routeTo, String arrivalTime,
			String departureTime, Integer seats, Integer avaiableSeats) {
		super();
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.avaiableSeats = avaiableSeats;
	}

	
	

	
}
