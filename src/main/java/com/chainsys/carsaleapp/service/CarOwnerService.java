package com.chainsys.carsaleapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chainsys.carsaleapp.dao.CarOwnerDAO;
import com.chainsys.carsaleapp.model.CarOrder;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.util.DbException;
@Service
public class CarOwnerService {
	@Autowired
	CarOwnerDAO carOwnerDAO;
	public void addCarOwner(CarOwner carOwner) throws ServiceException
	{
		try {
			carOwnerDAO.addCarOwner(carOwner);
		} catch (DbException e) {
			e.printStackTrace();
				}
	}
	void deleteCarDetail(int carOwnerId,int carId) throws ServiceException {
	try {
		carOwnerDAO.deleteCarDetail(carOwnerId, carId);
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public List<CarOwner> viewYourCar(long mobileNo) throws ServiceException {
		List<CarOwner> li=null;
		try {
		li=carOwnerDAO.viewYourCar(mobileNo);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	}
	public void updateCarPrice(CarOwner carOwner) throws ServiceException {
	try {
		carOwnerDAO.updateCarPrice(carOwner);
	} catch (DbException e) {
		e.printStackTrace();
	}
	
	}
	public boolean isCarOwnerAlreadyRegistered(Long mobileNo) throws ServiceException {
		boolean exists=false;
		try {
			exists=carOwnerDAO.isCarOwnerAlreadyRegistered(mobileNo);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return exists;
	}
	public List<CarOrder> viewYourPlacedCar(Long mobileNo) throws ServiceException {
		List<CarOrder> li=null;
		try {
			li=carOwnerDAO.viewYourPlacedCar(mobileNo);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	}




	


}
