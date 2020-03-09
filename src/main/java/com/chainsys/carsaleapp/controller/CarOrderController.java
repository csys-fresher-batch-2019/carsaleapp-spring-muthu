package com.chainsys.carsaleapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.carsaleapp.dao.CarOrderDAO;
import com.chainsys.carsaleapp.dao.impl.CarOrderImp;
import com.chainsys.carsaleapp.exception.DbException;
import com.chainsys.carsaleapp.model.CarOrder;

@RestController
@RequestMapping("api/order")
public class CarOrderController {
	CarOrderDAO obj = new CarOrderImp();

	@GetMapping("/getDeleveryDate")
	public List<CarOrder> getCarDeleveryDate(@RequestParam(name = "orderId") int orderId) {
		List<CarOrder> li = null;
		try {
			li = obj.getCarDeleveryDate(orderId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;

	}

	public void orderCar(@RequestBody CarOrder carOrder) {
		try {
			obj.orderCar(carOrder);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/get_delivery_car_detail")
	public List<CarOrder> getDeliveryCarDet(@RequestParam(name = "orderId") int orderId) {
		List<CarOrder> li = null;
		try {
			li = obj.getDeliveryCarDet(orderId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	}

	@GetMapping("/viewOrderedCar")
	public List<CarOrder> getOrderedCar(@RequestParam(name = "userId") Integer userId,
			@RequestParam(name = "sellerId") Integer sellerId) {
		List<CarOrder> li = null;
		try {
			if (userId != null) {

				li = obj.getOrderedCar(userId);

			} else if (sellerId != null) {
				li = obj.getOrderedUserCar(sellerId);
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	}

}
