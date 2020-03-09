package com.chainsys.carsaleapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsaleapp.dao.CarOwnerDAO;
import com.chainsys.carsaleapp.dao.impl.CarOwnerImp;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.util.DbException;

@RestController
@RequestMapping("api/user")
public class CarUserController {
CarOwnerDAO obj=new CarOwnerImp();
@PostMapping("/Registration")
public void registration(@RequestBody CarOwner carOwner)
{
	try {
		obj.addCarOwner(carOwner);
	} catch (DbException e) {
		e.printStackTrace();
	}
}
@GetMapping("/viewMyCar")
public List<CarOwner> viewYourCar(@RequestParam(name="mobileNo")long mobileNo){
	List<CarOwner> li=null;
	try {
		li=obj.viewYourCar(mobileNo);
	} catch (DbException e) {
		e.printStackTrace();
	}
	return li;
}

{
	
}
}
