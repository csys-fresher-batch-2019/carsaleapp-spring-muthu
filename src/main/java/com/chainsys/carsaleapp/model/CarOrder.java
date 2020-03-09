package com.chainsys.carsaleapp.model;

import java.sql.Date;

import lombok.Data;

@Data
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

	@Override
	public String toString() {
		return "CarOrder [orderId=" + orderId + ", BuyerName=" + BuyerName + ", BuyerContactNo=" + BuyerContactNo
				+ ", carId=" + carId + ", sellerId=" + sellerId + ", testDrive=" + testDrive + ", status=" + status
				+ ", userId=" + userId + ", orderedDate=" + orderedDate + ", deliveredDate=" + deliveredDate
				+ ", address1=" + address1 + ", address2=" + address2 + ", pincode=" + pincode + ", BuyerState="
				+ BuyerState + ", city=" + city + ", carName=" + carName + "]";
	}

}
