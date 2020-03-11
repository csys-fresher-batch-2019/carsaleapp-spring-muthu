package com.chainsys.carsaleapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsaleapp.dao.CarDetailDAO;
import com.chainsys.carsaleapp.dao.impl.CarDetailImp;
import com.chainsys.carsaleapp.dto.Message;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarDetail;

@RestController
@RequestMapping("api/cars")
public class CarController {
	@Autowired
	CarDetailDAO obj;

	@GetMapping("/user_login")
	public ResponseEntity<?> getSellerId(@RequestParam(name = "mobileNo") Long mobileNo,
			@RequestParam(name = "password") String password) {
		Integer sellerId = null;
		try {
			sellerId = obj.findByMobileNoAndPassword(mobileNo, password);
			return new ResponseEntity<>(sellerId, HttpStatus.OK);
		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("{id}")
	public ResponseEntity<?> listCar(@PathVariable("id") int carId) {
		List<CarDetail> li = null;

		try {
			li = obj.findOne(carId);
			return new ResponseEntity(li, HttpStatus.OK);

		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("/addCars")
	public ResponseEntity addCarDetail(@RequestBody CarDetail carDetail) {
		try {
			obj.save(carDetail);
			return new ResponseEntity(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/search")
	public ResponseEntity<?> search(@RequestParam(name = "min", required = false) Float min,
			@RequestParam(name = "max", required = false) Float max,
			@RequestParam(name = "carBrand", required = false) String carBrand,
			@RequestParam(name = "regState", required = false) String regState,
			@RequestParam(name = "carId", required = false) Integer carId) {
		List<CarDetail> ar = new ArrayList<CarDetail>();
		try {
			if (min != null) {
				ar = obj.findByAbovePrice(min);
			} else if (max != null) {
				ar = obj.findByBelowPrice(max);

			} else if (carBrand != null) {
				ar = obj.findByCarName(carBrand);

			} else if (carBrand != null && regState != null) {
				ar = obj.findByCarBrandAndRegState(carBrand, regState);

			} else if (carId != null) {
				ar = obj.findOne(carId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(ar, HttpStatus.OK);
	}
}
