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
@WebServlet("/SearchByCarPriceServlet")
public class SearchByCarPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String price=request.getParameter("price");
    //String price=(String) request.getAttribut("price");
    System.out.println(price);
    float pric=Float.parseFloat(price);
    CarDetail cd=new CarDetail();
    cd.setPrice((int)pric);
    CarDetailImp co=new CarDetailImp();
    if(pric <=490000)
    	    {
    	try {
			List<CarDetail> ar=co.getCarDetailBelowPrice(pric);
			request.setAttribute("carList", ar);
			System.out.println(price);
			RequestDispatcher dispatcher=request.getRequestDispatcher("SearchByPrice.jsp");
			dispatcher.forward(request, response);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    else
    {
    	try {
			List<CarDetail> ar=co.getCarDetailAbovePrice(pric);
			request.setAttribute("carList",ar);
			RequestDispatcher dispatcher=request.getRequestDispatcher("SearchByPrice.jsp");
			dispatcher.forward(request, response);
			System.out.println(price);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
