package com.chainsys.carsaleapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chainsys.carsaleapp.dao.impl.CarDetailImp;
import com.chainsys.carsaleapp.model.CarDetail;
import com.chainsys.carsaleapp.service.CarDetailService;
import com.chainsys.carsaleapp.exception.DbException;

/**
 * Servlet implementation class ViewAllCar
 */
@WebServlet("/ViewAllCar")
public class ViewAllCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Autowired
   CarDetailService co;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		try {
			List<CarDetail> list=co.viewAllCar();
			HttpSession session=request.getSession();
			request.setAttribute("viewAllCar",list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("ViewAllCar.jsp");
			dispatcher.forward(request, response);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
