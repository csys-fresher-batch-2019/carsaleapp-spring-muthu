package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.dao.impl.CarDetailImp;
import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.service.CarDetailService;
@WebServlet("/OrderCarServlet")
public class OrderCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    @Autowired
    CarDetailService cao;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String carId=request.getParameter("carId");
	   int car=Integer.parseInt(carId);
	    System.out.println(carId);
	    
	    CarDetail cd=new CarDetail();
	        cd.setCarId(car);
	            try {
			List<CarDetail> lcd=cao.getCarDetailUseCarId(car);
			request.setAttribute("cars",lcd);
			RequestDispatcher dispatcher=request.getRequestDispatcher("order.jsp");
			dispatcher.forward(request, response);
			 }catch(Exception e){
	    	   e.printStackTrace();
	       } 
   	}
}