package com.chainsys.carsaleapp.dao;

import java.util.List;

import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarDetail;

public interface CarDetailDAO {
	void save(CarDetail carDetail) throws DbException;

	public List<CarDetail> findByCarName(String carName) throws DbException;

	public List<CarDetail> findByCarBrandAndRegState(String carBrand, String regState) throws DbException;

	public List<CarDetail> findByCarBrand(String carBrand) throws DbException;

	public List<CarDetail> updateStatus(String status) throws DbException;

	public List<CarDetail> findByCarNameAndBrandAndFuelType(String carName, String carBrand, String fuelType) throws DbException;

	// public int verifyUser(int sellerIdd, String password) throws DbException;

	// public int getSellerId(Long mobileNo, String password) throws DbException;

	public List<CarDetail> findByMaxPrice(float max) throws DbException;

	public List<CarDetail> findByMaxPriceAndCarBrand(Float max, String carBrand) throws DbException;

	public List<CarDetail> findByMinPrice(Float min) throws DbException;

	public List<CarDetail> findByDrivenKmFromAndTo(float StartFrom, float endTo) throws DbException;

	public List<CarDetail> findByFuelType(String fuelType) throws DbException;

	public List<CarDetail> findOne(int carId) throws DbException;

	public List<CarDetail> findAll() throws DbException;

	public int findByMobileNoAndPassword(Long mobileNo, String password) throws DbException;

	public boolean findByRegNo(String regNo) throws DbException;
}
