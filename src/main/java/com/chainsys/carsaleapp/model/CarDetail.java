package com.chainsys.carsaleapp.model;

import java.time.LocalDate;

import lombok.Data;
@Data
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

	@Override
	public String toString() {
		return "CarDetail [carOwnerId=" + carOwnerId + ", carId=" + carId + ", carBrand=" + carBrand + ", carName="
				+ carName + ", trType=" + trType + ", fuelType=" + fuelType + ", regState=" + regState + ", regYear="
				+ regYear + ", registrationNo=" + registrationNo + ", drivenKm=" + drivenKm + ", updateDate="
				+ updateDate + ", price=" + price + ", status=" + status + ", carAvailableCity=" + carAvailableCity
				+ ", imageSrc=" + imageSrc + ", vehicleIdNo=" + vehicleIdNo + ", isOwner=" + isOwner + ", contactNo="
				+ contactNo + ", password=" + password + ", carOwner=" + carOwner + "]";
	}

}
