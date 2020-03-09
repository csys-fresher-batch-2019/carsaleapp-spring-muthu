package com.chainsys.carsaleapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.model.CarOrder;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.exception.DbException;
@Repository
public interface CarOwnerDAO {
	void addCarOwner(CarOwner carOwner) throws DbException;

	void deleteCarDetail(int carOwnerId, int carId) throws DbException;

	public List<CarOwner> viewYourCar(long mobileNo) throws DbException;

	void updateCarPrice(CarOwner carOwner) throws DbException;

	public boolean isCarOwnerAlreadyRegistered(Long mobileNo) throws DbException;

	public List<CarOrder> viewYourPlacedCar(Long mobileNo) throws DbException;
}
