package com.chainsys.carsaleapp.model;

import lombok.Data;

@Data
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

	@Override
	public String toString() {
		return "CarOwner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", contactNo=" + contactNo + ", address1="
				+ address1 + ", pincode=" + pincode + ", address2=" + address2 + ", city=" + city + ", state=" + state
				+ ", password=" + password + ", carDetail=" + carDetail + "]";
	}

}
