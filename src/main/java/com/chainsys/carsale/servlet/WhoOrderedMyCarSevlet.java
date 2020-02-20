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

import com.chainsys.carsale.dao.impl.CarOrderImp;
import com.chainsys.carsale.model.CarOrder;
import com.chainsys.carsale.util.DbException;


@WebServlet("/WhoOrderedMyCarSevlet")
public class WhoOrderedMyCarSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		CarOrderImp co=new CarOrderImp();
	 	HttpSession session = request.getSession();
		int sellerId=(Integer)session.getAttribute("login_seller_id");
	  try {
		List<CarOrder> li=co.getOrderedUserCar(sellerId);
		System.out.println("size:" + li.size());
		request.setAttribute("orderedlist",li);
		RequestDispatcher dispatcher=request.getRequestDispatcher("whoOrderedMyCar.jsp");
		dispatcher.forward(request, response);
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
   	}

	}
