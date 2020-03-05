package com.chainsys.carsale.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.carsale.dao.impl.CarOwnerImp;
import com.chainsys.carsale.model.CarOwner;
import com.chainsys.carsale.util.DbException;
@WebServlet("/CarOwnerValidateServlet")
public class CarOwnerValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CarOwnerImp coi = new CarOwnerImp();
		CarOwner coo = new CarOwner();
		long phNo = Long.parseLong(request.getParameter("phoneNo"));
		coo.setContactNo(phNo);
		Integer alreadyRegistered = 0;
		try {
			boolean exists = coi.isCarOwnerAlreadyRegistered(phNo);
			if (exists) {
				alreadyRegistered = 1;
			}
			else
			{
				alreadyRegistered = 0;	
			}
			System.out.println(exists);
		} catch (DbException e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println(alreadyRegistered);
		out.flush();

	}
}
