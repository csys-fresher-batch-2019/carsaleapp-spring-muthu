package com.chainsys.carsaleapp.model;

import java.sql.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CarOrder {
	private int orderId;
	private String BuyerName;
	private long BuyerContactNo;
	private int carId;
	private int sellerId;
	private String testDrive;
	private String status;
	private int userId;
	private Date orderedDate;
	private Date deliveredDate;
	private String address1;
	private String address2;
	private int pincode;
	private String BuyerState;
	private String city;
	private String carName;

}
