package com.chainsys.carsale.servlet;
import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		int sellerId = (Integer) session.getAttribute("login_seller_id");
		CarDetailImp ci = new CarDetailImp();
		CarDetail carDetail = new CarDetail();
		int price = Integer.parseInt(request.getParameter("price"));
		carDetail.setPrice(price);
		int isowner = Integer.parseInt(request.getParameter("isowner"));
		carDetail.setIsOwner(isowner);
		String carName = request.getParameter("carName");
		carDetail.setCarName(carName);
		String carBrand = request.getParameter("carBrand");
		carDetail.setCarBrand(carBrand);
		String trType = request.getParameter("tr");
		carDetail.setTrType(trType);
		String fuelType = request.getParameter("fuel");
		carDetail.setFuelType(fuelType);
		String regState = request.getParameter("regState");
		carDetail.setRegState(regState);
		String carAvailableCity = request.getParameter("carAvailableCity");
		carDetail.setCarAvailableCity(carAvailableCity);
		int regYear = Integer.parseInt(request.getParameter("regYear"));
		carDetail.setRegYear(regYear);
		int drKm = Integer.parseInt(request.getParameter("drKm"));
		carDetail.setDrivenKm(drKm);
		String regNo = request.getParameter("regNo");
		carDetail.setRegistrationNo(regNo);
		String vid = request.getParameter("vid");
		String imageSrc=request.getParameter("image");
		carDetail.setVehicleIdNo(vid);
		carDetail.setCarOwnerId(sellerId);
        carDetail.setImageSrc(imageSrc);		
			try {
				ci.addCarDetail(carDetail);
				System.out.println("Add success");
				RequestDispatcher dispatcher=request.getRequestDispatcher("LoginIndex.jsp");
				dispatcher.forward(request, response);
				
			  } catch (DbException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				RequestDispatcher dispatcher=request.getRequestDispatcher("addCar.jsp");
				dispatcher.forward(request, response);
			
			}
		
	}

}
