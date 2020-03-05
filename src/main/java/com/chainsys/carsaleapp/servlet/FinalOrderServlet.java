package com.chainsys.carsale.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.carsale.dao.impl.CarOrderImp;
import com.chainsys.carsale.model.CarOrder;
import com.chainsys.carsale.util.DbException;

@WebServlet("/FinalOrderServlet")
public class FinalOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buyerName=request.getParameter("BuyerName");
		Long buyerContact=Long.parseLong(request.getParameter("BuyerContactNo"));
		int carId=Integer.parseInt(request.getParameter("carId"));
		int sellerId=Integer.parseInt(request.getParameter("sellerId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		String testDrive=request.getParameter("testDr");
		String address1=request.getParameter("address1");
		String address2=request.getParameter("address2");
		String  buyerCity=request.getParameter("city");
		String buyerState=request.getParameter("state");
		int pincode=Integer.parseInt(request.getParameter("pincode"));
	    CarOrder co=new CarOrder();
	    co.setAddress1(address1);
	    co.setAddress2(address2);
	    co.setBuyerContactNo(buyerContact);
	    co.setBuyerName(buyerName);
	    co.setBuyerState(buyerState);
	    co.setCarId(carId);
	    co.setPincode(pincode);
	    co.setSellerId(sellerId);
	    co.setCity(buyerCity);
	    co.setTestDrive(testDrive);
	    co.setUserId(userId);
	    CarOrderImp coi=new CarOrderImp();
	    
	    try {
			coi.orderCar(co);
          	response.sendRedirect("OrderSuccess.jsp");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}

}
