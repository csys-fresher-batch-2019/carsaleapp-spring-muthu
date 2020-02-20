package com.chainsys.carsale.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.carsale.dao.impl.CarDetailImp;
import com.chainsys.carsale.model.CarDetail;
import com.chainsys.carsale.util.DbException;

@WebServlet("/SearchByBrandServlet")
public class SearchByBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carBrand=request.getParameter("carBrand");
		CarDetail cd=new CarDetail();
		cd.setCarBrand(carBrand);
		List<CarDetail> ar=new ArrayList<CarDetail>();
		CarDetailImp cdi=new CarDetailImp();
		try {
			ar=cdi.getCarDetail(carBrand);
			request.setAttribute("availableCar",ar);
			RequestDispatcher dispatcher=request.getRequestDispatcher("SearchByBrand.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
