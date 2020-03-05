package com.chainsys.carsaleapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.model.CarOrder;
import com.chainsys.carsaleapp.util.DbException;
@Repository
public interface CarOrderDAO {
	public void orderCar(CarOrder carOrder) throws DbException;

	public List<CarOrder> getCarDeleveryDate(int orderId) throws DbException;

	public List<CarOrder> getDeliveryCarDet(int orderId) throws DbException;

	public void updateCarStatus(int carId) throws DbException;

	public List<CarOrder> getOrderedCar(int userId) throws DbException;
	public List<CarOrder> getOrderedUserCar(int sellerId) throws DbException ;
		
}