package com.chainsys.carsale.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.carsale.dao.CarDetailDAO;
import com.chainsys.carsale.dao.impl.CarDetailImp;
import com.chainsys.carsale.model.CarDetail;
import com.chainsys.carsale.util.DbException;
@Service
public class CarDetailService {

	private CarDetailDAO carDetailDAO = new CarDetailImp();

	public void addCarDetail(CarDetail carDetail) throws ServiceException {
		try {
			// carvalidator.validate(carDetail);
			carDetailDAO.addCarDetail(carDetail);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}

	public List<CarDetail> getCarDetail(String carName) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getCarDetail(carName);

		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getDetailWithOwner(String carBrand) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getDetailWithOwner(carBrand);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getUpdatedCar(String status) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getUpdatedCar(status);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getCarDetail(String carName, String carBrand, String fuleType) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getCarDetail(carName, carBrand, fuleType);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getCarDetailAbovePrice(float max) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getCarDetailAbovePrice(max);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getCarDetail(Float max, String carBrand) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getCarDetail(max, carBrand);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> viewAllCar() throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.viewAllCar();
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getCarDetailBelowPrice(Float max) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.viewAllCar();
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

	public List<CarDetail> getCarDetailAboveDrivenKm(float from, float to) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getCarDetailAboveDrivenKm(from, to);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;

	}

	public List<CarDetail> getCarDetailUseCarId(int carId) throws ServiceException {
		List<CarDetail> ls = new ArrayList<CarDetail>();
		try {
			ls = carDetailDAO.getCarDetailUseCarId(carId);
		} catch (DbException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		return ls;
	}

}
