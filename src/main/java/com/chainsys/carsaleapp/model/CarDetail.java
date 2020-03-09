package com.chainsys.carsaleapp.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarDetail {
	private int carOwnerId;
	private int carId;
	private String carBrand;
	private String carName;
	private String trType;
	private String fuelType;
	private String regState;
	private int regYear;
	private String registrationNo;
	private int drivenKm;
	private LocalDate updateDate;
	private int price;
	private String status;
	private String carAvailableCity;
	private String imageSrc;
	private String vehicleIdNo;
	private int isOwner;
	private Long contactNo;
	private String password;

	private CarOwner carOwner;

}
