package com.chainsys.carsaleapp.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarOwner {
	private int ownerId;
	private String ownerName;
	private long contactNo;
	private String address1;
	private int pincode;
	private String address2;
	private String city;
	private String state;
	private String password;
	private CarDetail carDetail;

}
