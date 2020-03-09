package com.chainsys.carsaleapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.carsaleapp.dao.CarOwnerDAO;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.exception.ServiceException;
import com.chainsys.carsaleapp.model.CarOrder;
import com.chainsys.carsaleapp.model.CarOwner;

@Service
public class CarOwnerService {
	@Autowired
	CarOwnerDAO carOwnerDAO;

	public void addCarOwner(CarOwner carOwner) throws ServiceException {
		try {
			carOwnerDAO.save(carOwner);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	void deleteCarDetail(int carOwnerId, int carId) throws ServiceException {
		try {
			carOwnerDAO.delete(carOwnerId, carId);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<CarOwner> viewYourCar(long mobileNo) throws ServiceException {
		List<CarOwner> li = null;
		try {
			li = carOwnerDAO.findBymobileNo(mobileNo);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	}

	public void updateCarPrice(CarOwner carOwner) throws ServiceException {
		try {
			carOwnerDAO.update(carOwner);
		} catch (DbException e) {
			e.printStackTrace();
		}

	}

	public boolean isCarOwnerAlreadyRegistered(Long mobileNo) throws ServiceException {
		boolean exists = false;
		try {
			exists = carOwnerDAO.exists(mobileNo);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return exists;
	}
}
