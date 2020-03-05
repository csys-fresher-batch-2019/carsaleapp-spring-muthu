package com.chainsys.carsaleapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.carsaleapp.dao.CarOrderDAO;
import com.chainsys.carsaleapp.dao.impl.CarOrderImp;
import com.chainsys.carsaleapp.model.CarOrder;
import com.chainsys.carsaleapp.util.DbException;
@Service
public class CarOrderService {
	@Autowired
CarOrderDAO carOrderDAO;
	public void orderCar(CarOrder carOrder) throws ServiceException
	{
		try {
			carOrderDAO.orderCar(carOrder);
		}catch(DbException e)
		{
			throw new ServiceException(e);
		}
		
	}
	public List<CarOrder> getCarDeleveryDate(int orderId) throws ServiceException
	{
		List<CarOrder> col=null;
		try
		{
			col=carOrderDAO.getCarDeleveryDate(orderId);
			
		
	}catch(DbException e)
	{
		throw new ServiceException(e);
	}
		return col ;

}
	public List<CarOrder> getDeliveryCarDet(int orderId) throws ServiceException
	{
		List<CarOrder> li=null;
		try
		{
			li=carOrderDAO.getDeliveryCarDet(orderId);
		}catch(DbException e)
		{
			throw new ServiceException(e);
		}
		return null;
		
	}
	public void updateCarStatus(int carId) throws ServiceException {
	try {
		carOrderDAO.updateCarStatus(carId);
	}catch(DbException e)
	{
		throw new ServiceException(e);
	}
	
	}
	public List<CarOrder> getOrderedCar(int userId) throws  ServiceException{
		List<CarOrder> li=null;
		try
		{
		li=carOrderDAO.getOrderedCar(userId);	
		}catch(DbException e)
		{
			throw new ServiceException(e);
		}
		return li;
	}
	public List<CarOrder> getOrderedUserCar(int sellerId) throws ServiceException {
		List<CarOrder> li=null;
		try
		{
		li=carOrderDAO.getOrderedUserCar(sellerId);	
		}catch(DbException e)
		{
			throw new ServiceException(e);
		}
		return li;
	
	}

}

