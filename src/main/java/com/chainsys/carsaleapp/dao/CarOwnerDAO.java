package com.chainsys.carsaleapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarOwner;

@Repository
public interface CarOwnerDAO {
	void save(CarOwner carOwner) throws DbException;

	void delete(int carOwnerId, int carId) throws DbException;

	public List<CarOwner> findBymobileNo(long mobileNo) throws DbException;

	void update(CarOwner carOwner) throws DbException;

	public boolean exists(Long mobileNo) throws DbException;

}
