package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.model.CarOwner;
import com.chainsys.carsaleapp.service.CarOwnerService;

@WebServlet("/UpdateCarPrice")
public class UpdateCarPrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	CarOwnerService co;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession ses = request.getSession();
		// String carId = (String) request.getAttribute("carId");
		// int sellerId = (Integer) request.getAttribute("login_seller_id");
		String price = request.getParameter("price");
		CarDetail c = new CarDetail();
		String carId = request.getParameter("carId");
		String sellerId = request.getParameter("sellerId");
		int price1 = Integer.parseInt(price);
		int carId1 = Integer.parseInt(carId);
		int sellerId1 = Integer.parseInt(sellerId);
		System.out.println(carId);
		System.out.println(sellerId);
		System.out.println(price);
		// c.setCarId(carId1);
		// c.setPrice(price1);
		// c.setCarOwnerId(sellerId1);
		CarOwner cor = new CarOwner();

		c.setCarId(carId1);
		c.setPrice(price1);
		cor.setCarDetail(c);
		cor.setOwnerId(sellerId1);
		Integer success = 0;

		try {
			co.updateCarPrice(cor);
			success = 1;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(success);
		PrintWriter out = response.getWriter();
		out.write(success);
		out.flush();
	}
}
