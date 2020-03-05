package com.chainsys.carsale.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.carsale.model.CarOrder;
import com.chainsys.carsale.util.DbException;
@Repository
public interface CarOrderDAO {
	public void orderCar(CarOrder carOrder) throws DbException;

	public List<CarOrder> getCarDeleveryDate(int orderId) throws DbException;

	public List<CarOrder> getDeliveryCarDet(int orderId) throws DbException;

	public void updateCarStatus(int carId) throws DbException;

	public List<CarOrder> getOrderedCar(int userId) throws DbException;
}