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

import com.chainsys.carsale.dao.impl.CarDetailImp;
import com.chainsys.carsale.model.CarDetail;
import com.chainsys.carsale.util.DbException;

/**
 * Servlet implementation class ViewAllCar
 */
@WebServlet("/ ViewAllCar")
public class ViewAllCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CarDetailImp co=new CarDetailImp(); 
		try {
			List<CarDetail> list=co.viewAllCar();
			HttpSession session=request.getSession();
			request.setAttribute("viewAllCar",list);
			RequestDispatcher dispatcher=request.getRequestDispatcher("ViewAllCar.jsp");
			dispatcher.forward(request, response);
			
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
