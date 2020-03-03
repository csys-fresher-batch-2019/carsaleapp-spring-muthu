package com.chainsys.carsaleapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsale.dao.CarDetailDAO;
import com.chainsys.carsale.dao.impl.CarDetailImp;
import com.chainsys.carsale.model.CarDetail;
import com.chainsys.carsale.util.DbException;

@RestController
@RequestMapping("api")
public class CarController {

	
	@GetMapping("/Listcar")
	public List<CarDetail> list(@RequestParam("carId") int carid) {
		List<CarDetail> li=new ArrayList<>();
		CarDetailDAO obj = new CarDetailImp();
				try {
			li=obj.getCarDetailUseCarId(carid);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	
	}
	@PostMapping("/insertCar")
	void addCarDetail(CarDetail carDetail) {
		
		
	}
	
	
}
