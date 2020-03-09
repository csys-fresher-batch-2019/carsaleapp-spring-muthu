package com.chainsys.carsaleapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/getDeliveryDate")
	public List<CarOrder> getCarDeleveryDate(@RequestParam(name = "orderId") int orderId) {
		List<CarOrder> li = null;
		try {
			li = obj.findByOrderId(orderId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;

	}

	public void orderCar(@RequestBody CarOrder carOrder) {
		try {
			obj.save(carOrder);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/{orderId}")
	public CarOrder getDeliveryCarDet(@PathVariable("orderId") int orderId) {
		CarOrder co = null;
		try {
			co = obj.findCarDeliveryDetail(orderId);
		} catch (DbException e) {
			e.printStackTrace();
		}
		return co;
	}

	@GetMapping("/viewOrderedCar")
	public List<CarOrder> getOrderedCar(@RequestParam(name = "userId") Integer userId,
			@RequestParam(name = "sellerId") Integer sellerId) {
		List<CarOrder> li = null;
		try {
			if (userId != null) {

				li = obj.findByUserId(userId);

			} else if (sellerId != null) {
				li = obj.findBySellerId(sellerId);
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
		return li;
	}

}
