package com.chainsys.carsale.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.carsale.dao.impl.CarOwnerImp;
import com.chainsys.carsale.model.CarOwner;
import com.chainsys.carsale.util.DbException;
@WebServlet("/ViewCar")
public class ViewCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 
	   	HttpSession session = request.getSession();
		int sellerId = (Integer) session.getAttribute("login_seller_id");
		CarOwnerImp cdi=new CarOwnerImp();
		try {
			List<CarOwner> cars=cdi.viewYourCar(sellerId);
		request.setAttribute("totalCar",cars);
		RequestDispatcher dispatcher=request.getRequestDispatcher("updateCar.jsp");
		dispatcher.forward(request, response);
		} catch (DbException e) {
			e.printStackTrace();
		}
	}

}
