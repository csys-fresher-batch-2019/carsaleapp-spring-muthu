package com.chainsys.carsale.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class SearchCarServlet
 */
@WebServlet("/SearchCarServlet")
public class SearchCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 String carId=request.getParameter("carId");
   int car=Integer.parseInt(carId);
    System.out.println(carId);
    
    CarDetail cd=new CarDetail();
        cd.setCarId(car);
        CarDetailImp cao=new CarDetailImp();
       try {
		List<CarDetail> lcd=cao.getCarDetailUseCarId(car);
		System.out.println(lcd.size());
		request.setAttribute("carDetail", lcd);
		 RequestDispatcher dispatcher=request.getRequestDispatcher("viewFullDetail.jsp");
			dispatcher.forward(request, response);
		    
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
   	}
		

}
