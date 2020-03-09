package com.chainsys.carsaleapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsaleapp.dao.CarDetailDAO;
import com.chainsys.carsaleapp.dao.impl.CarDetailImp;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarDetail;

@RestController
@RequestMapping("api/cars")
public class CarController {
	CarDetailDAO obj = new CarDetailImp();
	@GetMapping("/user_login")
	public int getSellerId(@RequestParam(name = "mobileNo") Long mobileNo,
			@RequestParam(name = "password") String password) 
	{
		Integer sellerId=null;
		try {
			sellerId=obj.findByMobileNoAndPassword(mobileNo, password);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return sellerId;
		}
		@GetMapping("{id}")
	public List<CarDetail> list(@PathVariable("id") int carId) {
		List<CarDetail> li=new ArrayList<>();
		
				try {
					li=obj.findOne(carId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	
	}
	@PostMapping("/addCars")
	void addCarDetail(@RequestBody CarDetail carDetail) {
		try
		{
			obj.save(carDetail);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	@GetMapping("/search")
	public List<CarDetail>search(@RequestParam(name = "min", required = false) Float min,
			@RequestParam(name = "max", required = false) Float max,
			@RequestParam(name="carBrand",required=false) String carBrand,
			@RequestParam(name="regState",required=false) String regState,
			@RequestParam(name="carId",required=false) Integer carId)
	{
		List<CarDetail> ar = null;
		try
		{
			if (min != null) {
				ar=obj.findByMaxPrice(min);
			}
			else if (max !=null)
			{
				ar=obj.findByMinPrice(max);
				
			}
			else if(carBrand!=null && regState!=null )
			{
				ar=obj.findByCarBrandAndRegState(carBrand,regState);
			}
			else if(carBrand !=null)
			{
				ar=obj.findByCarName(carBrand);
			}
			else if(carId!=null)
			{
				ar=obj.findOne(carId);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ar;
		
	}
	}
