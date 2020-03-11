package com.chainsys.carsaleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsaleapp.dao.CarOwnerDAO;
import com.chainsys.carsaleapp.dao.impl.CarOwnerImp;
import com.chainsys.carsaleapp.dto.Message;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarOwner;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	CarOwnerDAO obj;

	@PostMapping("/Registration")
	public ResponseEntity<?> registration(@RequestBody CarOwner carOwner) {
		try {
			obj.save(carOwner);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/viewMyCar")
	public ResponseEntity<?> viewYourCar(@RequestParam(name = "mobileNo") long mobileNo) {
		List<CarOwner> li = null;
		try {
			li = obj.findBymobileNo(mobileNo);
			return new ResponseEntity(li, HttpStatus.OK);
		} catch (DbException e) {
			e.printStackTrace();
			Message msg = new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);

		}
	

	}
}
